package com.interfaced.brs.editor.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.interfaced.brs.lang.lexer.BrsLexer
import com.interfaced.brs.lang.psi.BrsTypes.*

class BrsHighlighter : SyntaxHighlighterBase() {
    override fun getTokenHighlights(type: IElementType?): Array<TextAttributesKey> {
        return when (type) {
            T_RETURN
                , T_DIM
                , T_STOP
                , T_GOTO
                , T_PRINT
                , T_NEXT
                , T_WHILE
                , T_IF
                , T_THEN
                , T_ELSE
                , T_ELSE_IF
                , T_FOR
                , T_TO
                , T_EACH
                , T_IN
                , T_FUNCTION
                , T_SUB
                , T_AS
                , T_AND
                , T_OR
                , T_MOD
                , T_NOT
                , T_EXIT
                , T_END
                , T_STEP
                , T_EXIT_WHILE
                , T_EXIT_FOR
                , T_END_WHILE
                , T_END_FOR
                , T_END_IF
                , T_END_FUNCTION
                , T_END_SUB
                , T_LIBRARY -> KEYWORD_KEYS
            T_INTEGER
                , T_FLOAT
                , T_DOUBLE
                , T_BOOLEAN
                , T_STRING
                , T_OBJECT
                , T_DYNAMIC
                , T_VOID
                , T_TRUE
                , T_FALSE
                , T_INVALID -> CONSTANT_KEYS
            T_INTEGER_LIT
                , T_FLOAT_LIT -> NUMBER_KEYS
            T_IDENTIFIER -> IDENTIFIER_KEYS
            T_COMMA -> COMMA_KEYS
            T_COMMENT -> COMMENT_KEYS
            T_STRING_LITERAL -> STRING_KEYS
            else -> EMPTY
        }
    }

    override fun getHighlightingLexer(): Lexer = BrsLexer()

    companion object {
        val KEYWORD = TextAttributesKey.createTextAttributesKey(
                "BRS.KEYWORD",
                DefaultLanguageHighlighterColors.KEYWORD
        )
        val COMMA = TextAttributesKey.createTextAttributesKey(
                "BRS.COMMA",
                DefaultLanguageHighlighterColors.COMMA
        )
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey(
                "BRS.IDENTIFIER",
                DefaultLanguageHighlighterColors.IDENTIFIER
        )
        val COMMENT = TextAttributesKey.createTextAttributesKey(
                "BRS.COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        val STRING = TextAttributesKey.createTextAttributesKey(
                "BRS.STRING",
                DefaultLanguageHighlighterColors.STRING
        )
        val CONSTANT = TextAttributesKey.createTextAttributesKey(
                "BRS.CONSTANT",
                DefaultLanguageHighlighterColors.CONSTANT
        )
        val NUMBER = TextAttributesKey.createTextAttributesKey(
                "BRS.NUMBER",
                DefaultLanguageHighlighterColors.NUMBER
        )

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val COMMA_KEYS = arrayOf(COMMA)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val STRING_KEYS = arrayOf(STRING)
        private val CONSTANT_KEYS = arrayOf(CONSTANT)
        private val NUMBER_KEYS = arrayOf(NUMBER)

        private val EMPTY = arrayOf<TextAttributesKey>()
    }
}