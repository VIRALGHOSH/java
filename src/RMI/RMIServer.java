/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

class Server extends UnicastRemoteObject implements RMIInterface
{
    Server()throws RemoteException{ }
        
    @Override
        public String hello(String name) throws RemoteException {
                return "Hello "+ name;
        }
  }

public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        Registry register=LocateRegistry.createRegistry(1099);
        register.rebind("MyServer", new Server());
        System.out.println("Aapka swagat hai");
    }
    
}
