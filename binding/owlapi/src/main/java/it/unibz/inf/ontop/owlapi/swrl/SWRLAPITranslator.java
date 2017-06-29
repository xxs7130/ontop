package it.unibz.inf.ontop.owlapi.swrl;

import it.unibz.inf.ontop.datalog.DatalogProgram;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.SWRLRule;


/**
 * Class that allows to create Datalog 
 * from SWRL rules in an ontology 
 *  
 */
public class SWRLAPITranslator {
	
	DatalogProgram program;
			
	public SWRLAPITranslator(OWLOntology ontology) {
		
		SWRLVisitor visitor = new SWRLVisitor();
		
		//get the axioms from the ontology and consider only the rules	
		program =visitor.createDatalog(ontology);
					
		
	}
	
	public SWRLAPITranslator(SWRLRule rule) {
		
		SWRLVisitor visitor = new SWRLVisitor();
		
		//transform the rule
		program =visitor.createDatalog(rule);
					
		
	}
	
	public DatalogProgram getDatalog(){
		return program;
		
	}
}
