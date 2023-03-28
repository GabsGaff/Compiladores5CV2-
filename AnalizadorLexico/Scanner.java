package AnalizadorLexico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private static final Map<String, TipoToken> palabrasReservadas;
    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASS);
        palabrasReservadas.put("falso", TipoToken.FALSE);
        palabrasReservadas.put("para", TipoToken.FOR);
        palabrasReservadas.put("fun", TipoToken.FUN);
        palabrasReservadas.put("si", TipoToken.SI);
        palabrasReservadas.put("nulo", TipoToken.NULL);
        palabrasReservadas.put("o", TipoToken.O);
        palabrasReservadas.put("imprimir", TipoToken.PRINT);
        palabrasReservadas.put("retorno", TipoToken.RETURN);
        palabrasReservadas.put("super", TipoToken.SUPER);
        palabrasReservadas.put("este", TipoToken.THIS);
        palabrasReservadas.put("verdadero", TipoToken.TRUE);
        palabrasReservadas.put("var", TipoToken.VAR);
        palabrasReservadas.put("mientras", TipoToken.WHILE);
        palabrasReservadas.put("si", TipoToken.IF);
        palabrasReservadas.put("entero", TipoToken.INT);
        palabrasReservadas.put("cadena", TipoToken.STRING);
        palabrasReservadas.put("mas", TipoToken.ELSE);
        palabrasReservadas.put("hacer", TipoToken.DO);
        palabrasReservadas.put("interruptor", TipoToken.SWITCH);
        palabrasReservadas.put("caso", TipoToken.CASE);
        palabrasReservadas.put("predeterminado", TipoToken.DEFAULT);
        palabrasReservadas.put("romper", TipoToken.BREAK);
        palabrasReservadas.put("continuar", TipoToken.CONTINUE);
        palabrasReservadas.put("probar", TipoToken.TRY);
        palabrasReservadas.put("atrapar", TipoToken.CATCH);
        palabrasReservadas.put("tirar", TipoToken.THROW);
        palabrasReservadas.put("fin", TipoToken.FINALLY);
        palabrasReservadas.put("publico", TipoToken.PUBLIC);
        palabrasReservadas.put("privado", TipoToken.PRIVATE);
        palabrasReservadas.put("protegido", TipoToken.PROTECTED);
        palabrasReservadas.put("clase", TipoToken.CLASS);
        palabrasReservadas.put("interfaz", TipoToken.INTERFACE);
        palabrasReservadas.put("enumeracion", TipoToken.ENUM);
        palabrasReservadas.put("extiende", TipoToken.EXTENDS);
        palabrasReservadas.put("implementa", TipoToken.IMPLEMENTS);
        palabrasReservadas.put("paquete", TipoToken.PACKAGE);
        palabrasReservadas.put("importa", TipoToken.IMPORT);
        palabrasReservadas.put("estatico", TipoToken.STATIC);
        palabrasReservadas.put("final", TipoToken.FINAL);
        palabrasReservadas.put("abstracto", TipoToken.ABSTRACT);
        palabrasReservadas.put("sincronizado", TipoToken.SYNCHRONIZED);
        palabrasReservadas.put("volatil", TipoToken.VOLATILE);
        palabrasReservadas.put("transient", TipoToken.TRANSIENT);
        palabrasReservadas.put("nativo", TipoToken.NATIVE);
        palabrasReservadas.put("super", TipoToken.SUPER); 
        palabrasReservadas.put("instancia", TipoToken.INSTANCEOF);
        palabrasReservadas.put("nuevo", TipoToken.NEW);

        /* palabras reservadas
        IF, ELSE, WHILE, FOR, DO, SWITCH, CASE, DEFAULT,
    BREAK, CONTINUE, RETURN, TRY, CATCH, THROW, FINALLY,
    PUBLIC, PRIVATE, PROTECTED, CLASS, INTREFACE, ENUM, EXTENDS,
    IMPLEMENTS, PACKAGE, IMPORT, STATIC, FINAL, ABSTRACT, SYNCHRONIZED,
    VOLATILE, TRANSIENT, NATIVE, SUPER, THIS, INSTANCEOF, NEW, TRUE, FALSE, NULL, */

    }

    Scanner(String source){
        this.source = source;
    }

    List<Token> scanTokens(){
        //Aquí va el corazón del scanner.

        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF, "", null, linea));

        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */