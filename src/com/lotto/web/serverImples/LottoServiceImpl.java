package com.lotto.web.serverImples;

import java.util.Random;

import com.lotto.web.daoImples.LottoDAOImpl;
import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.servers.LottoService;

public class LottoServiceImpl implements LottoService {
	Random ran;
	private LottoBean lotto;
	private LottoDAO dao;
	public LottoServiceImpl() {
		ran = new Random();
		lotto = new LottoBean();
		dao = new LottoDAOImpl();
	}
	@Override
	public void createLotto(LottoBean param) {
		param.setBall(createBall());
		param.setLotteryNum(createLotteryNum());
		param.setLottoSeq(createLottoSeq());
		dao.insertLotto(param);
		System.out.println(param.toString());
	}
	@Override
	public String createLottoSeq() {
		String seq = String.format("%04d", ran.nextInt(9999));
		seq = "No."+seq;
		lotto.setLottoSeq(seq);
		return seq;
	}
	@Override
	public String createBall() {
		return String.valueOf(ran.nextInt(45)+1);
	}
	@Override
	public String createLotteryNum() {
		String lotto = "";
		int[] nums = new int[6];
		int num = 0;
		boolean b= false;
		for(int i = 0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(createBall());
			if(nums[i] == 0) {
				i--;
			} else {
				for(int j= 0; j<i; j++) {
					if(nums[i] == nums[j]) {
						i--;
						break;
					}else {
						break;
					}
				}
			}
		}
		for(int i = 0; i<nums.length-1; i++) {
			b=false;
			for(int j = 0; j<nums.length-1-i; j++) {
				if(nums[j]>nums[j+1]) {
					num = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = num;
					b=true;
				}
			}
			if(!b) {
				break;
			}
		}
		lotto = String.format("%s,%s,%s,%s,%s,%s", nums[0],nums[1],nums[2],nums[3],nums[4],nums[5]);
		return lotto;
	}
	

}
