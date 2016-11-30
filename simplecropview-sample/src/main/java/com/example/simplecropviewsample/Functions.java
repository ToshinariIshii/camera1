package com.example.simplecropviewsample;

public class Functions {

	/*ピクセル毎にHSV格納*/
	public static double[][] convertRGBIntoHSV(double[][] rgb, int xsize, int ysize) {
		double[][] hsv = new double[xsize*ysize][3];
		for (int i = 0; i < xsize * ysize; i++) {
			double sort[] = new double[3];// RGBの、昇順
			double agent = -810;
			sort[0] = rgb[i][0];
			sort[1] = rgb[i][1];
			sort[2] = rgb[i][2];// 初期化みたいなもん
			for (int j = 0; j < 3; j++) {
				for (int k = j + 1; k < 3; k++) {
					if (sort[j] < sort[k]) {// 単純交換ソート
						agent = sort[j];
						sort[j] = sort[k];
						sort[k] = agent;
					}
				}
			}

			/* 色相H */
			if(sort[0]==sort[2])
				hsv[i][1] = 0;
			else if (sort[0] == rgb[i][0])
				hsv[i][0] = 60 * ((rgb[i][1] - rgb[i][2]) / (sort[0] - sort[2]));
			else if (sort[0] == rgb[i][1])
				hsv[i][0] = 60 * ((rgb[i][2] - rgb[i][0]) / (sort[0] - sort[2])) + 120;
			else if (sort[0] == rgb[i][2])
				hsv[i][0] = 60 * ((rgb[i][0] - rgb[i][1]) / (sort[0] - sort[2])) + 240;
			else
				hsv[i][0] = 0;
			if (hsv[i][0] < 0)
				hsv[i][0] += 360;

			//hsv[i][0] /= 3.6;// Hが0~100の場合

			/* 彩度S */
			if(sort[0]!=sort[2])
				hsv[i][1] = ((sort[0] - sort[2]) / sort[0]) * 255;// Sが0~255の場合
				//hsv[i][1] = ((sort[0] - sort[2]) / sort[0]) * 100;// Sが0~100の場合
			else
				hsv[i][1] = 0;

			/* 明度V */
			hsv[i][2] = sort[0];// Vが0~255の場合
			//hsv[i][2] = sort[0] / 255 * 100;// Vが0~100の場合
		}

		return hsv;
	}

	/*HSVそれぞれの平均値をだすメソッド*/
	public static double[] MajorHSV(double[][] hsv, int xsize, int ysize) {
		double[] majorHSV = new double[] {0,0,0};//HSVそれぞれの平均値を格納する
		int maxh = 0,maxs = 0,maxv = 0;//ここ int maxh,maxs,maxv = 0; って書き方してたのが、上書きされない原因だった
		int fh[] = new int[360];
		//int fs[] = new int[100];
		//int fv[] = new int[100];
		int fs[] = new int[255];
		int fv[] = new int[255];

		/* 初期値 */
		for (int i = 0; i < 360; i++) {
			fh[i] = 0;
		}
		//for (int i = 0; i < 100; i++) {
		for (int i = 0; i < 255; i++) {
			fs[i] = 0;
			fv[i] = 0;
		}

		/* 頻度(検出されるたび+1する) */
		for (int i = 0; i < xsize * ysize; i++) {
			//if(hsv[i][1] >= 99) hsv[i][1] = 99;
			//if(hsv[i][2] >= 99) hsv[i][2] = 99;
			if(hsv[i][1] >= 254) hsv[i][1] = 254;
			if(hsv[i][2] >= 254) hsv[i][2] = 254;
			fh[(int)hsv[i][0]]++;
			fs[(int)hsv[i][1]]++;
			fv[(int)hsv[i][2]]++;
		}

		/* いちばん出現頻度の高いHをだす */
		for(int i = 0; i < 360; i++){
			if(maxh < fh[i]){
				majorHSV[0] = i;
				maxh = fh[i];
			}
		}
		/* いちばん出現頻度の高いSとVをだす */
		//for(int i = 0; i < 100; i++){
		for(int i = 0; i < 255; i++){
			if(maxs < fs[i]){
				majorHSV[1] = i;
				maxs = fs[i];
			}
			if(maxv < fv[i]){
				majorHSV[2] = i;
				maxv = fv[i];
			}
		}
		return majorHSV;
	}


	/*RGBそれぞれの平均値をだすメソッド*/
	public static int[] convertHSVIntoRGB(double[] majorHSV) {
		int[] majorRGB = new int[] {0,0,0};//HSVそれぞれの平均値を格納する
		double max = majorHSV[2];
		double min = max - ((majorHSV[1] / 255) * max);

		switch((int)(majorHSV[0]/60)){
			//0 ~ 60
			case 0:
				majorRGB[0] = (int)max;
				majorRGB[1] = (int)((majorHSV[0] / 60) * (max - min) + min);
				majorRGB[2] = (int)min;
				break;
			//60 ~ 120
			case 1:
				majorRGB[0] = (int)(((120 - majorHSV[0]) / 60) * (max - min) + min);
				majorRGB[1] = (int)max;
				majorRGB[2] = (int)min;
				break;
			//120 ~ 180
			case 2:
				majorRGB[0] = (int)min;
				majorRGB[1] = (int)max;
				majorRGB[2] = (int)(((majorHSV[0] - 120) / 60) * (max - min) + min);;
				break;
			//180 ~ 240
			case 3:
				majorRGB[0] = (int)min;
				majorRGB[1] = (int)(((240 - majorHSV[0]) / 60) * (max - min) + min);
				majorRGB[2] = (int)max;
				break;
			//240 ~ 300
			case 4:
				majorRGB[0] = (int)(((majorHSV[0] - 240) / 60) * (max - min) + min);
				majorRGB[1] = (int)min;
				majorRGB[2] = (int)max;
				break;
			//300 ~ 360
			case 5:
				majorRGB[0] = (int)max;
				majorRGB[1] = (int)min;
				majorRGB[2] = (int)(((360 - majorHSV[0]) / 60) * (max - min) + min);
				break;
			default:
				majorRGB[0] = 0;
				majorRGB[1] = 0;
				majorRGB[2] = 0;
				break;

		}
		return majorRGB;
	}


	/*便色カードのHSV*/
	public static double[][] sampleHSV = {
			{70, 17.47572816, 80.78431373}, {50.14925373, 33.33333333, 78.82352941},
			{52.74725275, 43.96135266, 81.17647059}, {54.46808511, 65.27777778, 84.70588235},
			{44.72318651, 74.620284, 75.55119826}, {34.35114504, 71.58469945, 71.76470588},
			{45.38461538, 60, 50.98039216},
			/*腸重積Intuss*/{339.2145533, 70.79330729, 38.49308965},
			/*メレナMelena*/{78.77163244, 22.60532315, 9.496979412 }};


	/*指定画像がどのUnkoColorに近いか判別*/
	public static int result(double[] majorHSV){
		int r = -1;
		double dmin = 360;//difference HSVの差分の最小
		double d;//difference

		if(majorHSV[2] < 20*255/100)// うんこ黒かったら9に分類
			return 9;
		if((majorHSV[0] < 30 || majorHSV[0] > 200) && majorHSV[1] > 17*255/100)// うんこ赤かったら8に分類
			return 8;
		if(majorHSV[1] >= 0 && majorHSV[1] < 25*255/100 && majorHSV[2] > 75*255/100)// 白さと明度に応じて1 ~ 4判別
			return 1;
		if(majorHSV[1] < 39*255/100 && majorHSV[2] > 75*255/100)
			return 2;
		if(majorHSV[1] < 55*255/100 && majorHSV[2] > 75*255/100)
			return 3;
		if(majorHSV[1] < 70*255/100 && majorHSV[2] > 75*255/100)
			return 4;
		for(int i=4; i<7; i++){ // 色相に応じて5 ~ 7判別
			d = majorHSV[0] - sampleHSV[i][0];
			if(d < 0)
				d = -d;//dを絶対値に
			if(d > 180)
				d = 360 - d;//0と360を同義に
			if(d < dmin){
				dmin = d;
				r = i;
			}
		}
		return r + 1;// +1するのは、0~6を1~7に直すため
	}

	/*判別結果を出力*/
	public static String outputResult(int dResult){
		String r;
		r = "ウンチ判別結果: 「" + dResult + "」\n\n";
		switch(dResult) {
			case 1:
				r += "2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。\n";
				break;
			case 2:
				r += "2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。\n";
				break;
			case 3:
				r += "2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。\n";
				break;
			case 4:
				r += "6~7日観察を続け、判別結果が「4」のまま、あるいは1~3へと変化したら\n最寄りの小児科(もしくは産科)を受診しましょう。\n";
				break;
			case 5:
				r += "健康なウンチであると思われます。\n";
				break;
			case 6:
				r += "健康なウンチであると思われます。\n";
				break;
			case 7:
				r += "健康なウンチであると思われます。\n";
				break;
			case 8:
				r += "ウンチに赤みがかかっています。\n" + "2~3日以内に最寄りの小児科(もしくは産科)を受診しましょう。\n";
				break;
			case 9:
				r += "ウンチの黒みが非常に強いです。\n";
				break;
			default:

				break;

		}

		return r;
	}



	public static String valueOfHaisetu(int seek){
		switch (seek){
			case 0:
				return "0. ぜんぜん出ていない";
			case 1:
				return "1. 少し出た";
			case 2:
				return "2. いつもくらい";
			case 3:
				return "3. けっこう出た";
			case 4:
				return "4. ものすごく出た";
			default:
				return "うんちまみれ"; // 例外処理
		}
	}

	public static String valueOfMizupposa(int seek){
		switch (seek){
			case 0:
				return "0. ｶｯｽｶｽ";
			case 1:
				return "1. 乾き気味";
			case 2:
				return "2. いつもくらい";
			case 3:
				return "3. 少し水っぽい";
			case 4:
				return "4. ものすごく水っぽい";
			default:
				return "うんちまみれ"; // 例外処理
		}
	}

}
