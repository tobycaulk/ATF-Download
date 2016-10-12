package com.atf.otd.dropbox;

import java.io.ByteArrayOutputStream;

import com.dropbox.core.DbxClient;

public interface DropboxService {
	
	public DbxClient login();
	
	public ByteArrayOutputStream getSFMStream();

}
