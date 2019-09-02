package com.lotto.web.servers;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public String createLottoSeq();
	public String createBall();
	public String createLotteryNum();
}

