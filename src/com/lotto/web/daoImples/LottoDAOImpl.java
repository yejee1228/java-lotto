package com.lotto.web.daoImples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;

public class LottoDAOImpl implements LottoDAO{
	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-lotto%sWebContent%sresource%stxt%s",
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator,
			File.separator);
	@Override
	public void insertLotto(LottoBean param) {
		try{
			File file = new File(FILE_PATH+"lottos.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(param.toString());
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
