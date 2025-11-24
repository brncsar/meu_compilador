// Generated from linguagem/MinhaLinguagem.g4 by ANTLR 4.13.2

    package linguagem; // Nome do pacote

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MinhaLinguagemParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MinhaLinguagemVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MinhaLinguagemParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(MinhaLinguagemParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MinhaLinguagemParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(MinhaLinguagemParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(MinhaLinguagemParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(MinhaLinguagemParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#repeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeticao(MinhaLinguagemParser.RepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MinhaLinguagemParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(MinhaLinguagemParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#doWhileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileLoop(MinhaLinguagemParser.DoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#leitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeitura(MinhaLinguagemParser.LeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#escrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscrita(MinhaLinguagemParser.EscritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinhaLinguagemParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(MinhaLinguagemParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numero}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(MinhaLinguagemParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(MinhaLinguagemParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenteses}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenteses(MinhaLinguagemParser.ParentesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(MinhaLinguagemParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(MinhaLinguagemParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Texto}
	 * labeled alternative in {@link MinhaLinguagemParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTexto(MinhaLinguagemParser.TextoContext ctx);
}