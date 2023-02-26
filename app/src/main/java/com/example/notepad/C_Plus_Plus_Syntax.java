package com.example.notepad;

import android.content.Context;

import com.amrdeveloper.codeview.CodeView;

import java.util.regex.Pattern;

public class C_Plus_Plus_Syntax {
    // Keywords
    private static final Pattern PATTERN_KEYWORD = Pattern.compile("\\b(asm|double|new|switch|auto|else|operator|template|" +
            "break|enum|private|this|case|extern|protected|throw|catch|float|public|try|while|" +
            "char|for|register|typedef|class|friend|return|union|const|goto|short|unsigned|struct|" +
            "continue|if|signed|virtual|default|inline|sizeof|void|delete|int|static|volatile|do|long|\\b)");
    // Built in constraints BRACKETS/COLONS etc.
    private static final Pattern PATTERN_BUILTIN = Pattern.compile("[,:;[->]{}()]");
    // Attributes
    private static final Pattern PATTERN_ATTRIBUTE = Pattern.compile("\\.[a-zA-Z0-9_]+");
    // Data specific highlights
    private static final Pattern PATTERN_NUMBER = Pattern.compile("\\b(\\d*[.]?\\d+)\\b");
    // Operations
    private static final Pattern PATTERN_OPERATION = Pattern.compile( ":|==|>|<|!=|>=|<=|->|=|>|<|%|-|-=|%=|\\+|\\-|\\-=|\\+=|\\^|\\&|\\|::|\\?|\\*");
    // Character highlights
    private static final Pattern PATTERN_CHAR = Pattern.compile("'[a-zA-Z]'");
    // String highlights
    private static final Pattern PATTERN_STRING = Pattern.compile("\".*\"");
    // Hex color codes for highlights
    private static final Pattern PATTERN_HEX = Pattern.compile("0x[\\da-fA-F]+");
    // To do comments
    private static final Pattern PATTERN_TODO_COMMENT = Pattern.compile("//TODO[^\n]*");
    // General comments
    private static final Pattern PATTERN_COMMENT = Pattern.compile("//(?!TODO )[^\\n]*" + "|" + "/\\*(.|\\R)*?\\*/");

    // Theme
    public static void applyMonokaiTheme(Context context, CodeView codeView) {
        codeView.resetSyntaxPatternList();

        //View Background
        codeView.setBackgroundColor(codeView.getResources().getColor(R.color.monokia_pro_black));

        //Syntax Colors. Taking Patterns and assigning them colors retrieved from getResources
        codeView.addSyntaxPattern(PATTERN_HEX, context.getResources().getColor(R.color.monokia_pro_purple));
        codeView.addSyntaxPattern(PATTERN_CHAR, context.getResources().getColor(R.color.monokia_pro_green));
        codeView.addSyntaxPattern(PATTERN_STRING, context.getResources().getColor(R.color.monokia_pro_orange));
        codeView.addSyntaxPattern(PATTERN_NUMBER, context.getResources().getColor(R.color.monokia_pro_purple));
        codeView.addSyntaxPattern(PATTERN_KEYWORD, context.getResources().getColor(R.color.monokia_pro_pink));
        codeView.addSyntaxPattern(PATTERN_BUILTIN, context.getResources().getColor(R.color.monokia_pro_white));
        codeView.addSyntaxPattern(PATTERN_COMMENT, context.getResources().getColor(R.color.monokia_pro_grey));
        codeView.addSyntaxPattern(PATTERN_ATTRIBUTE, context.getResources().getColor(R.color.monokia_pro_sky));
        codeView.addSyntaxPattern(PATTERN_OPERATION, context.getResources().getColor(R.color.monokia_pro_pink));

        //Default Colors
        codeView.setTextColor( context.getResources().getColor(R.color.monokia_pro_white));
        codeView.addSyntaxPattern(PATTERN_TODO_COMMENT, context.getResources().getColor(R.color.green));
        // Highlights text after pattern impelementation
        codeView.reHighlightSyntax();
    }
}
