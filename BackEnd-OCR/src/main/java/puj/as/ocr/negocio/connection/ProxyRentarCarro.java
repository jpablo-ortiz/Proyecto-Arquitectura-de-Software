package puj.as.ocr.negocio.connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import javax.ejb.Stateless;

/**
 *
 * @author Grupo 3
 */
@Stateless
public class ProxyRentarCarro {

    private static final String URL_RENTAR_CARRO = "http://localhost:8080/BackEnd-InstitucionFinanciera";

    public String prueba() throws IOException {
        // Con proxy intermedio
        URL weburl = new URL(URL_RENTAR_CARRO + "/rentarCarro"); // Ejemplo
        
        Proxy webProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 3128));
        HttpURLConnection webProxyConnection = (HttpURLConnection) weburl.openConnection(webProxy);
        
        // Directo
        HttpURLConnection directConnection = (HttpURLConnection) weburl.openConnection(Proxy.NO_PROXY);
        
        
        Object content = directConnection.getContent();
        return (String) content;
    }
}
