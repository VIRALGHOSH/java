/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class server extends UnicastRemoteObject implements TempInterface {

    server() throws RemoteException{}
    @Override
    public Double convertF2C(Double fahrenheit) throws RemoteException {
        Double celsius =(fahrenheit - 32)*5/9;
        return celsius;
    }
}
        
public class TempServer {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("TempServer", new server());
        System.out.println("Welcome");
    }
}
