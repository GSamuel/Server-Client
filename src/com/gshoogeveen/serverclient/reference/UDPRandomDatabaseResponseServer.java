package com.gshoogeveen.serverclient.reference;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Arrays;

public class UDPRandomDatabaseResponseServer extends UDPServer
{
	public final static int DEFAULT_PORT = 7;
	
	private ArrayList<byte[]> list = new ArrayList<byte[]>();

	public UDPRandomDatabaseResponseServer()
	{
		super(DEFAULT_PORT);
	}

	@Override
	public void respond(DatagramSocket socket, DatagramPacket packet)
			throws IOException
	{
		byte[] newData = Arrays.copyOf(packet.getData(), packet.getLength());
		list.add(newData);
		
		newData = list.get((int)(Math.random()*list.size()));
		
	    DatagramPacket outgoing = new DatagramPacket(newData, 
	        newData.length, packet.getAddress(), packet.getPort());
	    socket.send(outgoing);
	}
	
	public static void main(String[] args) {
	    UDPServer server = new UDPRandomDatabaseResponseServer();
	    Thread t = new Thread(server);
	    t.start();
	  }
}
