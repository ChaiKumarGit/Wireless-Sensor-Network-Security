public interface Interface extends java.rmi.Remote
{
   
		public int update(String query) throws java.rmi.RemoteException;
		public int nodevalidation(String nodename,String password,String ipaddress,int portnumber,String status)throws java.rmi.RemoteException;
		public String insertNode(String nodename,String password,String iadr) throws java.rmi.RemoteException;
		public int checkLogin(String name,String pwd,String ipaddress) throws java.rmi.RemoteException;
		public String average()throws java.rmi.RemoteException;
		public String keyvalues()throws java.rmi.RemoteException;
}
