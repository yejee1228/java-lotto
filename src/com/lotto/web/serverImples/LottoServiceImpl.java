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
		for(int i = 0; i<nums.length; i++) {
			num = Integer.parseInt(createBall());		
			if(exist(nums, num)) {
				nums[i] = num;
			}else {
				i--;
			}
			System.out.print(nums[i]);

		}
		nums = bubbleSort(nums, true);
		
		for(int i= 0; i<nums.length; i++) {
			if(i != nums.length-1) {
				lotto+=nums[i]+",";
			}else {
				lotto+=nums[i];
			}
		}
		return lotto;
	}
	@Override
	public boolean exist(int[] arr, int a) {
		boolean b = false;
		for(int i : arr ){
			if(i != a) {
				b= true;
			}
		}
		return b;
	}
	@Override
	public int[] bubbleSort(int[] nums, boolean flag) {
		int num = 0;
		for(int i = 0; i<nums.length-1; i++) {
			for(int j = 0; j<nums.length-1; j++) {
				if(flag) {
					if(nums[j]>nums[j+1]) {
						num = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = num;
					}
				} else {
					if(nums[j]<nums[j+1]) {
						num = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = num;
					}
				}
				
			}
		}
		return nums;
	}
	

}
