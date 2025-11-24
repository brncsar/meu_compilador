// Generated from linguagem/MinhaLinguagem.g4 by ANTLR 4.13.2

    package linguagem; // Nome do pacote

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinhaLinguagemParser}.
 */
public interface MinhaLinguagemListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MinhaLinguagemParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MinhaLinguagemParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(MinhaLinguagemParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(MinhaLinguagemParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MinhaLinguagemParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MinhaLinguagemParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(MinhaLinguagemParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(MinhaLinguagemParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(MinhaLinguagemParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(MinhaLinguagemParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(MinhaLinguagemParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(MinhaLinguagemParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#repeticao}.
	 * @param ctx the parse tree
	 */
	void enterRepeticao(MinhaLinguagemParser.RepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#repeticao}.
	 * @param ctx the parse tree
	 */
	void exitRepeticao(MinhaLinguagemParser.RepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MinhaLinguagemParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MinhaLinguagemParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MinhaLinguagemParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MinhaLinguagemParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#doWhileLoop}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileLoop(MinhaLinguagemParser.DoWhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#doWhileLoop}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileLoop(MinhaLinguagemParser.DoWhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#leitura}.
	 * @param ctx the parse tree
	 */
	void enterLeitura(MinhaLinguagemParser.LeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#leitura}.
	 * @param ctx the parse tree
	 */
	void exitLeitura(MinhaLinguagemParser.LeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#escrita}.
	 * @param ctx the parse tree
	 */
	void enterEscrita(MinhaLinguagemParser.EscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#escrita}.
	 * @param ctx the parse tree
	 */
	void exitEscrita(MinhaLinguagemParser.EscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinhaLinguagemParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(MinhaLinguagemParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinhaLinguagemParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(MinhaLinguagemParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterNumero(MinhaLinguagemParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitNumero(MinhaLinguagemParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(MinhaLinguagemParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(MinhaLinguagemParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterParenteses(MinhaLinguagemParser.ParentesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitParenteses(MinhaLinguagemParser.ParentesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(MinhaLinguagemParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(MinhaLinguagemParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(MinhaLinguagemParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(MinhaLinguagemParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Texto}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterTexto(MinhaLinguagemParser.TextoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Texto}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitTexto(MinhaLinguagemParser.TextoContext ctx);
}