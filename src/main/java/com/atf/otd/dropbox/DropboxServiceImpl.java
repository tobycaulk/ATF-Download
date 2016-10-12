package com.atf.otd.dropbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Locale;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Service;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;

@Service
public class DropboxServiceImpl implements DropboxService {

	private static final String ACCESS_TOKEN = "fA0pV28plSAAAAAAAAAACPFpum1rDjWeG0noD-U2MiiaDUz8dC6eHCyPIPcUDMxC";
	private static final String APP_NAME = "As Time Fades Website";
	private static final String SFM_DB_FILE_PATH = "/Summer For Months.mp3";
	
	@Override
	public DbxClient login() {
		DbxRequestConfig config = new DbxRequestConfig(APP_NAME, Locale.getDefault().toString());
		DbxClient client = new DbxClient(config, ACCESS_TOKEN);
		
		return client;
	}

	@Override
	public ByteArrayOutputStream getSFMStream() {
		Logger.info("Downloading Summer For Months");
		ByteArrayOutputStream stream = null;
		
		DbxClient client = login();
		if(client != null) {
			try {
				stream = new ByteArrayOutputStream();
				client.getFile(SFM_DB_FILE_PATH, null, stream);
			} catch (DbxException | IOException e) {
				e.printStackTrace();
			}
		} else {
			Logger.error("DbxClient is null");
		}
		
		return stream;
	}
}
