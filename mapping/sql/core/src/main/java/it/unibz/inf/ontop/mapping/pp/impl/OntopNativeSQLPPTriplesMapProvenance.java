package it.unibz.inf.ontop.mapping.pp.impl;


import it.unibz.inf.ontop.pp.PPTriplesMapProvenance;

import java.util.stream.Collectors;

public class OntopNativeSQLPPTriplesMapProvenance implements PPTriplesMapProvenance {

    private final OntopNativeSQLPPTriplesMap triplesMap;

    public OntopNativeSQLPPTriplesMapProvenance(OntopNativeSQLPPTriplesMap triplesMap) {
        this.triplesMap = triplesMap;
    }

    @Override
    public String getProvenanceInfo() {
        String info = "id: " + triplesMap.getId();
        info += "\ntarget atoms: " + triplesMap.getTargetAtoms().stream()
                .map(a -> a.toString())
                .collect(Collectors.joining(", "));
        info += "\nsource query: " + triplesMap.getSourceQuery();
        return info;
    }

    @Override
    public String toString() {
        return getProvenanceInfo();
    }
}
