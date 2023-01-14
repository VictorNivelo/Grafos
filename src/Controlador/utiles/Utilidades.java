/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ivangonzalez
 */
public class Utilidades {

    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
//            System.out.println(aux.getName());
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }

        return atributo;
    }

    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Integer")) {
                transformar = Integer.parseInt(dato);
            }
        } else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;
        } else if(atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
            transformar = Boolean.parseBoolean(dato);
        }
        else {
            transformar = dato;
        }
        return transformar;
    }

    public static String encriptar(String dato) {
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }

    public static String desencriptar(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    //Otra forma
    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncription = clave.getBytes("UTF-8");
//        MessageDigest sha = MessageDigest.getInstance("SHA-1");
//        claveEncription = sha.digest(claveEncription);
        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }

    //admin123
    public static String encriptarClave(String datos, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

//        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datos.getBytes("UTF-8"));
//        String encriptado = encriptar(new String(bytesEncriptados));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    public static String desencriptarClave(String datos, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);
    }

    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length() == 13) ? cedula.substring(0,10) : cedula;
//        String baj = cedula.substring(10, 13);
        
        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    
    public static Boolean isNumber(Class clase){
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }
    
    public static Boolean isBoolean(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean IsPrimitive(Class clase){
        return clase.isPrimitive();
    }
    
    public static Boolean isObject(Class clase){
        return (!IsPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase));
    }
    
    
    
    public static void main(String[] args) {
//        System.out.println(Utilidades.encriptar("clave"));
//        System.out.println(Utilidades.desencriptar("TWFtYSBHdWV2bw=="));
        try {
            String claveSecreta = "XABC345";
            String dato = "Marylin";
            System.out.println(Utilidades.encriptarClave(dato, claveSecreta));
            System.out.println(Utilidades.desencriptarClave("crth6PAR67eXoOjBn+0RiQ==", "XABC345"));
            //77+9Tu+/ve+/vQkHJu+/vTTvv71W77+9byk=
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
