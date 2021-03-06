package it.unibz.inf.ontop.cli;

import org.junit.Test;

public class OntopR2RMLToOBDATest {


    //@Ignore("too expensive to run")
    @Test
    public void testOntopHelp (){
        String[] argv = {"help", "mapping", "to-obda"};
        Ontop.main(argv);
    }

    //@Ignore("too expensive to run")
    @Test
    public void testOntopR2RMLToOBDA (){
        String[] argv = {"mapping", "to-obda",
                "-i", "src/test/resources/books/exampleBooks.ttl",
                "-o", "src/test/resources/output/converted-exampleBooks.obda"
        };
        Ontop.main(argv);
    }

    @Test
    public void testOntopR2RMLToOBDA2 (){
        String[] argv = {"mapping", "to-obda",
                "-i", "src/test/resources/mapping.ttl",
                "-o", "src/test/resources/output/mapping-booktutorial.obda"
        };
        Ontop.main(argv);
    }



}
