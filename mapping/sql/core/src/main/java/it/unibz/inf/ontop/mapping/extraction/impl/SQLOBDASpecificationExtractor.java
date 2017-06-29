package it.unibz.inf.ontop.mapping.extraction.impl;

import com.google.inject.Inject;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.mapping.SQLMappingParser;
import it.unibz.inf.ontop.mapping.conversion.SQLPPMapping2OBDASpecificationConverter;
import it.unibz.inf.ontop.iq.tools.ExecutorRegistry;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.OBDASpecificationExtractor;
import it.unibz.inf.ontop.mapping.extraction.PreProcessedMapping;
import it.unibz.inf.ontop.dbschema.DBMetadata;
import it.unibz.inf.ontop.model.SQLPPMapping;
import it.unibz.inf.ontop.ontology.Ontology;
import org.eclipse.rdf4j.model.Model;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.Reader;
import java.util.Optional;

public class SQLOBDASpecificationExtractor implements OBDASpecificationExtractor {

    private final SQLMappingParser mappingParser;
    private final SQLPPMapping2OBDASpecificationConverter converter;

    @Inject
    private SQLOBDASpecificationExtractor(SQLMappingParser mappingParser,
                                          SQLPPMapping2OBDASpecificationConverter converter) {
        this.mappingParser = mappingParser;
        this.converter = converter;
    }

    @Override
    public OBDASpecification extract(@Nonnull File mappingFile, @Nonnull Optional<DBMetadata> dbMetadata,
                                     @Nonnull Optional<Ontology> ontology, @Nonnull Optional<File> constraintFile,
                                     ExecutorRegistry executorRegistry)
            throws OBDASpecificationException {

        SQLPPMapping ppMapping =  mappingParser.parse(mappingFile);
        return convertToDataSourceModel(ppMapping, dbMetadata, ontology, constraintFile, executorRegistry);
    }

    @Override
    public OBDASpecification extract(@Nonnull Reader mappingReader, @Nonnull Optional<DBMetadata> dbMetadata,
                                     @Nonnull Optional<Ontology> ontology, @Nonnull Optional<File> constraintFile,
                                     ExecutorRegistry executorRegistry)
            throws OBDASpecificationException {
        SQLPPMapping ppMapping =  mappingParser.parse(mappingReader);
        return convertToDataSourceModel(ppMapping, dbMetadata, ontology, constraintFile, executorRegistry);
    }

    @Override
    public OBDASpecification extract(@Nonnull Model mappingGraph, @Nonnull Optional<DBMetadata> dbMetadata,
                                     @Nonnull Optional<Ontology> ontology, @Nonnull Optional<File> constraintFile,
                                     ExecutorRegistry executorRegistry)
            throws OBDASpecificationException {
        SQLPPMapping ppMapping =  mappingParser.parse(mappingGraph);
        return convertToDataSourceModel(ppMapping, dbMetadata, ontology, constraintFile, executorRegistry);
    }

    @Override
    public OBDASpecification extract(@Nonnull PreProcessedMapping ppMapping, @Nonnull Optional<DBMetadata> dbMetadata,
                                     @Nonnull Optional<Ontology> ontology, @Nonnull Optional<File> constraintFile,
                                     ExecutorRegistry executorRegistry)
            throws OBDASpecificationException {
        if (ppMapping instanceof SQLPPMapping) {
            return convertToDataSourceModel((SQLPPMapping) ppMapping, dbMetadata, ontology, constraintFile, executorRegistry);
        }
        else {
            throw new IllegalArgumentException("SQLDataSourceModelExtractor only accepts OBDAModel as PreProcessedMapping");
        }
    }

    private OBDASpecification convertToDataSourceModel(SQLPPMapping ppMapping, Optional<DBMetadata> dbMetadata,
                                                       Optional<Ontology> ontology, @Nonnull Optional<File> constraintFile,
                                                       ExecutorRegistry executorRegistry)
            throws OBDASpecificationException {
        return converter.convert(ppMapping, dbMetadata, ontology, constraintFile, executorRegistry);
    }
}
