package it.unibz.inf.ontop.protege.gui.treemodels;

/*
 * #%L
 * ontop-protege
 * %%
 * Copyright (C) 2009 - 2013 KRDB Research Centre. Free University of Bozen Bolzano.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.Function;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.SQLPPTriplesMap;
import it.unibz.inf.ontop.model.term.Term;

import java.util.List;

/**
 * This Filter receives a string and returns true if any mapping contains the
 * string given in any of its head atoms.
 */
public class MappingHeadVariableTreeModelFilter extends TreeModelFilter<SQLPPTriplesMap> {

	public MappingHeadVariableTreeModelFilter() {
		super.bNegation = false;
	}

	@Override
	public boolean match(SQLPPTriplesMap object) {
		ImmutableList<ImmutableFunctionalTerm> atoms = object.getTargetAtoms();

		boolean isMatch = false;
		for (String keyword : vecKeyword) {
			for (int i = 0; i < atoms.size(); i++) {
				Function predicate = (Function) atoms.get(i);
				isMatch = isMatch || match(keyword.trim(), predicate);
			}
			if (isMatch) {
				break; // end loop if a match is found!
			}
		}
		// no match found!
		return (bNegation ? !isMatch : isMatch);
	}

	/** A helper method to check a match */
	public static boolean match(String keyword, Function predicate) {
		if (predicate.getFunctionSymbol().toString().indexOf(keyword) != -1) { // match found!
			return true;
		}

		// If the predicate name is mismatch, perhaps the terms.
		final List<Term> queryTerms = predicate.getTerms();
		for (int j = 0; j < queryTerms.size(); j++) {
			Term term = queryTerms.get(j);
			if (term.toString().indexOf(keyword) != -1) { // match found!
				return true;
			}
		}
		return false;
	}
}
