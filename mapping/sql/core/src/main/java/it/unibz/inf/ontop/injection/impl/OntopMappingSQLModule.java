package it.unibz.inf.ontop.injection.impl;


import com.google.common.collect.ImmutableList;
import com.google.inject.Module;
import it.unibz.inf.ontop.injection.NativeQueryLanguageComponentFactory;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.injection.OntopMappingSQLConfiguration;
import it.unibz.inf.ontop.injection.OntopMappingSQLSettings;
import it.unibz.inf.ontop.mapping.SQLPPMappingConverter;
import it.unibz.inf.ontop.model.SQLMappingParser;
import it.unibz.inf.ontop.nativeql.RDBMetadataExtractor;
import it.unibz.inf.ontop.spec.MappingExtractor;
import it.unibz.inf.ontop.spec.PreProcessedImplicitRelationalDBConstraintExtractor;

public class OntopMappingSQLModule extends OntopAbstractModule {


    private final OntopMappingSQLSettings settings;

    protected OntopMappingSQLModule(OntopMappingSQLConfiguration configuration) {
        super(configuration.getSettings());
        settings = configuration.getSettings();
    }

    @Override
    protected void configure() {
        bind(OntopMappingSQLSettings.class).toInstance(settings);

        bindFromPreferences(SQLPPMappingFactory.class);
        bindFromPreferences(SQLMappingParser.class);
        bindFromPreferences(SQLPPMappingConverter.class);
        //bindFromPreferences(MappingVocabularyFixer.class);
        bindFromPreferences(PreProcessedImplicitRelationalDBConstraintExtractor.class);
        bindFromPreferences(MappingExtractor.class);

        Module nativeQLFactoryModule = buildFactory(
                ImmutableList.of(RDBMetadataExtractor.class),
                NativeQueryLanguageComponentFactory.class);
        install(nativeQLFactoryModule);
    }
}
