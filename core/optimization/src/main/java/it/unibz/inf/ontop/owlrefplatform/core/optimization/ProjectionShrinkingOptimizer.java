package it.unibz.inf.ontop.owlrefplatform.core.optimization;

import it.unibz.inf.ontop.iq.IntermediateQuery;

public interface ProjectionShrinkingOptimizer extends IntermediateQueryOptimizer {
    /**
     * Does not throw an EmptyQueryException
     */
    @Override
    IntermediateQuery optimize(IntermediateQuery query);
}
