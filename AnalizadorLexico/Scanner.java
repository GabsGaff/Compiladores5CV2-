import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Scanner {
    
    private Reader input;
    private int currentChar;
    private Map<String, TipoToken> palabrasReservadas;
    
    public Scanner(Reader input) {
        this.input = input;
        this.currentChar = -1;
        this.palabrasReservadas = new HashMap<>();
        this.palabrasReservadas.put("y", TipoToken.Y);
        this.palabrasReservadas.put("si", TipoToken.IF);
        this.palabrasReservadas.put("mas", TipoToken.ELSE);
        this.palabrasReservadas.put("mientras", TipoToken.WHILE);
        this.palabrasReservadas.put("para", TipoToken.FOR);
        this.palabrasReservadas.put("hacer", TipoToken.DO);
        this.palabrasReservadas.put("interruptor", TipoToken.SWITCH);
        this.palabrasReservadas.put("caso", TipoToken.CASE);
        this.palabrasReservadas.put("predeterminado", TipoToken.DEFAULT);
        this.palabrasReservadas.put("romper", TipoToken.BREAK);
        this.palabrasReservadas.put("continuar", TipoToken.CONTINUE);
        this.palabrasReservadas.put("regresar", TipoToken.RETURN);
        this.palabrasReservadas.put("probar", TipoToken.TRY);
        this.palabrasReservadas.put("atrapar", TipoToken.CATCH);
        this.palabrasReservadas.put("tirar", TipoToken.THROW);
        this.palabrasReservadas.put("finalmente", TipoToken.FINALLY);
        this.palabrasReservadas.put("publico", TipoToken.PUBLIC);
        this.palabrasReservadas.put("privado", TipoToken.PRIVATE);
        this.palabrasReservadas.put("protegido", TipoToken.PROTECTED);
        this.palabrasReservadas.put("clase", TipoToken.CLASS);
        this.palabrasReservadas.put("interface", TipoToken.INTERFACE);
        this.palabrasReservadas.put("enum", TipoToken.ENUM);
        this.palabrasReservadas.put("extiende", TipoToken.EXTENDS);
        this.palabrasReservadas.put("implementar", TipoToken.IMPLEMENTS);
        this.palabrasReservadas.put("paquete", TipoToken.PACKAGE);
        this.palabrasReservadas.put("importar", TipoToken.IMPORT);
        this.palabrasReservadas.put("estatico", TipoToken.STATIC);
        this.palabrasReservadas.put("final", TipoToken.FINAL);
        this.palabrasReservadas.put("abstracto", TipoToken.ABSTRACT);
        this.palabrasReservadas.put("sincronizado", TipoToken.SYNCHRONIZED);
        this.palabrasReservadas.put("volatil", TipoToken.VOLATILE);
        this.palabrasReservadas.put("transient", TipoToken.TRANSIENT);
        this.palabrasReservadas.put("nativo", TipoToken.NATIVE);
        this.palabrasReservadas.put("super", TipoToken.SUPER);
        this.palabrasReservadas.put("este", TipoToken.THIS);
        this.palabrasReservadas.put("instancia", TipoToken.INSTANCEOF);
        this.palabrasReservadas.put("nuevo", TipoToken.NEW);
        this.palabrasReservadas.put("verdadero", TipoToken.TRUE);
        this.palabrasReservadas.put("falso", TipoToken.FALSE);
        this.palabrasReservadas.put("vacio", TipoToken.NULL);
    }
    
    private int nextChar() throws IOException {
        return currentChar = input.read();
    }
    
    private boolean isLetter(int c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    private boolean isDigit(int c) {
        return c >= '0' && c <= '9';
    }
    
    public Token getNextToken() throws IOException {
        int estado = 0;
        String lexema = "";
        
        while (currentChar != -1) {
            switch (estado) {
                case 0:
                    if (isLetter(currentChar)) {
                        estado = 1;
                        lexema += (char)currentChar;
                        nextChar();
                    } else if (isDigit(currentChar)) {
                        estado = 2;
                        lexema += (char)currentChar;
                        nextChar();
                    } else if (currentChar == '+') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.SUMA, lexema);
                    } else if (currentChar == '-') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.RESTA, lexema);
                    } else if (currentChar == ';') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.PUNTO_Y_COMA, lexema);

                     } else if (currentChar == '.') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.PUNTO, lexema);
                     } else if (currentChar == ':') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.DOS_PUNTOS, lexema);
                    } else if (currentChar == ',') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.COMA, lexema);
                    } else if (currentChar == '?') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.SIGNO_DE_INTERROGACION, lexema);    
                    } else if (currentChar == '!') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.SIGNO_DE_EXCLAMACION, lexema);
                    } else if (currentChar == '[') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.COCHETE_IZQ, lexema);
                    } else if (currentChar == ']') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.COCHETE_IZQ, lexema);
                    } else if (currentChar == '{') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.LLAVE_IZQ, lexema);
                    } else if (currentChar == '}') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.LLAVE_DER, lexema);
                    } else if (currentChar == '_') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.GUION_BAJO, lexema);
                    } else if (currentChar == '¨') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.DIERESIS, lexema);
                    } else if (currentChar == '/') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.DIAGONAL, lexema);
                    } else if (currentChar == '*') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.MULTIPLICACION, lexema);
                    } else if (currentChar == '#') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.NUMERAL, lexema);
                    } else if (currentChar == '&') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.AMPERSAND, lexema);
                    } else if (currentChar == '%') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.PORCENTAJE, lexema);
                    } else if (currentChar == '>') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.MAYORQUE, lexema);
                    } else if (currentChar == '<') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.MENORQUE, lexema);
                    } else if (currentChar == '>=') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.MAYOR_IGUAL, lexema);
                    } else if (currentChar == '<=') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.MENOR_IGUAL, lexema);
                    } else if (currentChar == '=') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.IGUAL, lexema);
                    } else if (currentChar == '""') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.COMILLAS_DOB, lexema);
                    } else if (currentChar == '''') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.COMILLAS_SIMP, lexema);
                    } else if (currentChar == '|') {
                        estado = 3;
                        lexema += (char)currentChar;
                        nextChar();
                        return new Token(TipoToken.PIPA, lexema);
                    } else if (currentChar == ' ') {
                        nextChar();
                    } else {
                        throw new RuntimeException("Caracter no reconocido: " + (char)currentChar);
                    }
                    break;
                    
                    
                case 1:
                    if (isLetter(currentChar) || isDigit(currentChar)) {
                        lexema += (char)currentChar;
                        nextChar();
                    } else {
                        estado = 3;
                        TipoToken tipo = palabrasReservadas.get(lexema.toUpperCase());
                        if (tipo == null) {
                            tipo = TipoToken.IDENTIFICADOR;
                        }
                        return new Token(tipo, lexema);
                    }
                    break;
                    
                case 2:
                    if (isDigit(currentChar)) {
                        lexema += (char)currentChar;
                        nextChar();
                    } else {
                        estado = 3;
                        return new Token(TipoToken.NUMERO, lexema);
                    }
                    break;

                case 3:
                    if (isDigit(currentChar)) {
                        lexema += (char)currentChar;
                        nextChar();
                    } else {
                        estado = 3;
                        return new Token(TipoToken.LETRA, lexema);
                    }
                    break;

                default:
                    throw new RuntimeException("Estado no válido: " + estado);
            }
        }
        
        return new Token(TipoToken.EOF, "");
    }
    
}

    