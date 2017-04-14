package br.com.luizfeltes.triangle.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * This is the main class to run the embedded http server to serve the API
 * 
 * @author Luiz Feltes
 */
public class TriangleServer {

    /**
     * Main method with the args from command line to run the embedded http server
     * 
     * @param args the args
     */
    public static void main(String[] args) {
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(getContextHandler());
        runServer(jettyServer);
    }
    
    /**
     * Run the server
     * 
     * @param jettyServer the server object
     */
    private static void runServer(Server jettyServer) {
        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            jettyServer.destroy();
        }
    }
    
    /**
     * Return the ServletContextHandler 
     * 
     * @return the ServletContextHandler 
     */
    private static ServletContextHandler getContextHandler() {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");        
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);        
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                TriangleAPI.class.getCanonicalName());        
        return context;        
    }

}
