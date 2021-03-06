package it.unibz.inf.ontop.model.term;

/*
 * #%L
 * ontop-obdalib-core
 * %%
 * Copyright (C) 2009 - 2014 Free University of Bozen-Bolzano
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
import it.unibz.inf.ontop.model.term.functionsymbol.OperationPredicate;
import it.unibz.inf.ontop.model.term.functionsymbol.Predicate;
import it.unibz.inf.ontop.model.term.functionsymbol.Predicate.COL_TYPE;

import java.util.List;

public interface TermFactory {

	/**
	 * Construct a {@link Predicate} object.
	 *
	 * @param uri
	 *            the name of the predicate (defined as a URI).
	 * @param arity
	 *            the number of elements inside the predicate.
	 * @return a predicate object.
	 */
	@Deprecated
	public Predicate getPredicate(String uri, int arity);

	public Predicate getPredicate(String uri, COL_TYPE[] types);

	public Predicate getObjectPropertyPredicate(String name);

	public Predicate getDataPropertyPredicate(String name, COL_TYPE type);

	public Predicate getAnnotationPropertyPredicate(String name);

	/**
	 * with default type COL_TYPE.LITERAL
	 * @param name
	 * @return
	 */
	
	public Predicate getDataPropertyPredicate(String name);
	
	public Predicate getClassPredicate(String name);

	public Predicate getOWLSameAsPredicate();

	public Predicate getOBDACanonicalIRI();

	/*
	 * Built-in function predicates
	 */

	public Function getUriTemplate(Term...terms);

	public Function getUriTemplate(List<Term> terms);

	ImmutableFunctionalTerm getImmutableUriTemplate(ImmutableTerm...terms);

	ImmutableFunctionalTerm getImmutableUriTemplate(ImmutableList<ImmutableTerm> terms);
	
	public Function getUriTemplateForDatatype(String type);
	

	public Function getBNodeTemplate(List<Term> terms);

	public Function getBNodeTemplate(Term... terms);

	ImmutableFunctionalTerm getImmutableBNodeTemplate(ImmutableTerm... terms);

	ImmutableFunctionalTerm getImmutableBNodeTemplate(ImmutableList<ImmutableTerm> terms);
	
	/**
	 * Construct a {@link Function} object. A function expression consists of
	 * functional symbol (or functor) and one or more arguments.
	 * 
	 * @param functor
	 *            the function symbol name.
	 * @param terms
	 *            a list of arguments.
	 * @return the function object.
	 */
	public Function getFunction(Predicate functor, Term... terms);

	Expression getExpression(OperationPredicate functor, List<Term> arguments);

	ImmutableExpression getImmutableExpression(OperationPredicate functor, ImmutableTerm... arguments);

	ImmutableExpression getImmutableExpression(OperationPredicate functor,
											   ImmutableList<? extends ImmutableTerm> arguments);

	ImmutableExpression getImmutableExpression(Expression expression);

	public Function getFunction(Predicate functor, List<Term> terms);

	public ImmutableFunctionalTerm getImmutableFunctionalTerm(Predicate functor, ImmutableList<ImmutableTerm> terms);

	public ImmutableFunctionalTerm getImmutableFunctionalTerm(Predicate functor, ImmutableTerm... terms);

	public ImmutableFunctionalTerm getImmutableFunctionalTerm(Function functionalTerm);

	public NonGroundFunctionalTerm getNonGroundFunctionalTerm(Predicate functor, ImmutableTerm... terms);

	public NonGroundFunctionalTerm getNonGroundFunctionalTerm(Predicate functor, ImmutableList<ImmutableTerm> terms);


	public Expression getExpression(OperationPredicate functor, Term... arguments);

	/*
	 * Boolean function terms
	 */

	public Expression getFunctionEQ(Term firstTerm, Term secondTerm);

	public Expression getFunctionGTE(Term firstTerm, Term secondTerm);

	public Expression getFunctionGT(Term firstTerm, Term secondTerm);

	public Expression getFunctionLTE(Term firstTerm, Term secondTerm);

	public Expression getFunctionLT(Term firstTerm, Term secondTerm);

	public Expression getFunctionNEQ(Term firstTerm, Term secondTerm);

	public Expression getFunctionNOT(Term term);

	public Expression getFunctionAND(Term term1, Term term2);

	public Expression getFunctionOR(Term term1, Term term2);

	public Expression getFunctionIsTrue(Term term);

	public Expression getFunctionIsNull(Term term);

	public Expression getFunctionIsNotNull(Term term);

	public Expression getLANGMATCHESFunction(Term term1, Term term2);
	
	// ROMAN (23 Dec 2015): LIKE comes only from mappings
	public Expression getSQLFunctionLike(Term term1, Term term2);


	/*
	 * Casting values cast(source-value AS destination-type)
	 */
	public Expression getFunctionCast(Term term1, Term term2);

	/**
	 * Construct a {@link URIConstant} object. This type of term is written as a
	 * usual URI construction following the generic URI syntax specification
	 * (RFC 3986).
	 * <p>
	 * <code>
	 * scheme://host:port/path#fragment
	 * </code>
	 * <p>
	 * Examples:
	 * <p>
	 * <code>
	 * http://example.org/some/paths <br />
	 * http://example.org/some/paths/to/resource#frag01 <br />
	 * ftp://example.org/resource.txt <br />
	 * </code>
	 * <p>
	 * are all well-formed URI strings.
	 * 
	 * @param uri
	 *            the URI.
	 * @return a URI constant.
	 */
	public URIConstant getConstantURI(String uri);
	
	public BNode getConstantBNode(String name);

	public ValueConstant getBooleanConstant(boolean value);
	
	/**
	 * Construct a {@link ValueConstant} object.
	 * 
	 * @param value
	 *            the value of the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value);

	/**
	 * Construct a {@link ValueConstant} object with a type definition.
	 * <p>
	 * Example:
	 * <p>
	 * <code>
	 * "Person"^^xsd:String <br />
	 * 22^^xsd:Integer
	 * </code>
	 * 
	 * @param value
	 *            the value of the constant.
	 * @param type
	 *            the type of the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value, Predicate.COL_TYPE type);


	/**
	 * Construct a {@link ValueConstant} object with a language tag.
	 * <p>
	 * Example:
	 * <p>
	 * <code>
	 * "This is American English"@en-US <br />
	 * </code>
	 * 
	 * @param value
	 *            the value of the constant.
	 * @param language
	 *            the language tag for the constant.
	 * @return the value constant.
	 */
	public ValueConstant getConstantLiteral(String value, String language);

	public Function getTypedTerm(Term value, String language);
	public Function getTypedTerm(Term value, Term language);
	public Function getTypedTerm(Term value, Predicate.COL_TYPE type);

	ImmutableFunctionalTerm getImmutableTypedTerm(ImmutableTerm value, String language);
	ImmutableFunctionalTerm getImmutableTypedTerm(ImmutableTerm value, ImmutableTerm language);
	ImmutableFunctionalTerm getImmutableTypedTerm(ImmutableTerm value, Predicate.COL_TYPE type);

	/**
	 * Construct a {@link Variable} object. The variable name is started by a
	 * dollar sign ('$') or a question mark sign ('?'), e.g.:
	 * <p>
	 * <code>
	 * pred($x) <br />
	 * func(?x, ?y)
	 * </code>
	 * 
	 * @param name
	 *            the name of the variable.
	 * @return the variable object.
	 */
	public Variable getVariable(String name);
}
