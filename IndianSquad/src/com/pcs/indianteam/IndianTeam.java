package com.pcs.indianteam;

import android.os.Parcel;
import android.os.Parcelable;

public class IndianTeam implements Parcelable{
		
		private String FirstMember;
		private String SecondMember;
		private String ThirdMember;
		private String FourthMember;
		private String FifthMember;
		private String SixthMember;
		private String SeventhMember;
		private String EigthMember;
		private String NinthMember;
		private String TenthMember;
		private String ElevenMember;
		private String TwelveMember;
		private String ThirteenMember;
		private String FourteenMember;
		private String FifteenMember;
		private String SixteenMember;
		
		
		public IndianTeam(Parcel source) {
			setFirstMember(source.readString());
			setSecondMember(source.readString());
			setThirdMember(source.readString());
			setFourthMember(source.readString());
			setFifthMember(source.readString());
			setSixthMember(source.readString());
			setSeventhMember(source.readString());
			setEigthMember(source.readString());
			setNinthMember(source.readString());
			setTenthMember(source.readString());
			setElevenMember(source.readString());
			setTwelveMember(source.readString());
			setThirteenMember(source.readString());
			setFourteenMember(source.readString());
			setFifteenMember(source.readString());
			setSixteenMember(source.readString());
		}

		public IndianTeam() {
			// TODO Auto-generated constructor stub
		}

		public String getFirstMember() {
			return FirstMember;
		}

		public void setFirstMember(String firstMember) {
			FirstMember = firstMember;
		}

		public String getSecondMember() {
			return SecondMember;
		}

		public void setSecondMember(String secondMember) {
			SecondMember = secondMember;
		}

		public String getThirdMember() {
			return ThirdMember;
		}

		public void setThirdMember(String thirdMember) {
			ThirdMember = thirdMember;
		}

		public String getFourthMember() {
			return FourthMember;
		}

		public void setFourthMember(String fourthMember) {
			FourthMember = fourthMember;
		}

		public String getFifthMember() {
			return FifthMember;
		}

		public void setFifthMember(String fifthMember) {
			FifthMember = fifthMember;
		}

		public String getSixthMember() {
			return SixthMember;
		}

		public void setSixthMember(String sixthMember) {
			SixthMember = sixthMember;
		}

		public String getSeventhMember() {
			return SeventhMember;
		}

		public void setSeventhMember(String seventhMember) {
			SeventhMember = seventhMember;
		}

		public String getEigthMember() {
			return EigthMember;
		}

		public void setEigthMember(String eigthMember) {
			EigthMember = eigthMember;
		}

		public String getNinthMember() {
			return NinthMember;
		}

		public void setNinthMember(String ninthMember) {
			NinthMember = ninthMember;
		}

		public String getTenthMember() {
			return TenthMember;
		}

		public void setTenthMember(String tenthMember) {
			TenthMember = tenthMember;
		}

		public String getElevenMember() {
			return ElevenMember;
		}

		public void setElevenMember(String elevenMember) {
			ElevenMember = elevenMember;
		}

		public String getTwelveMember() {
			return TwelveMember;
		}

		public void setTwelveMember(String twelveMember) {
			TwelveMember = twelveMember;
		}

		public String getThirteenMember() {
			return ThirteenMember;
		}

		public void setThirteenMember(String thirteenMember) {
			ThirteenMember = thirteenMember;
		}

		public String getFourteenMember() {
			return FourteenMember;
		}

		public void setFourteenMember(String fourteenMember) {
			FourteenMember = fourteenMember;
		}

		public String getFifteenMember() {
			return FifteenMember;
		}

		public void setFifteenMember(String fifteenMember) {
			FifteenMember = fifteenMember;
		}

		public String getSixteenMember() {
			return SixteenMember;
		}

		public void setSixteenMember(String sixteenMember) {
			SixteenMember = sixteenMember;
		}
		@Override
		public int describeContents() {

			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(getFirstMember());
			dest.writeString(getSecondMember());
			dest.writeString(getThirdMember());
			dest.writeString(getFourthMember());
			dest.writeString(getFifthMember());
			dest.writeString(getSixthMember());
			dest.writeString(getSeventhMember());
			dest.writeString(getEigthMember());
			dest.writeString(getNinthMember());
			dest.writeString(getTenthMember());
			dest.writeString(getElevenMember());
			dest.writeString(getTwelveMember());
			dest.writeString(getThirteenMember());
			dest.writeString(getFourteenMember());
			dest.writeString(getFifteenMember());
			dest.writeString(getSixteenMember());

		}
		public static final Creator<IndianTeam> CREATOR = new Creator<IndianTeam>() {

			@Override
			public IndianTeam createFromParcel(Parcel source) {

				return new IndianTeam(source);
			}

			@Override
			public IndianTeam[] newArray(int size) {

				return new IndianTeam[size];
			}
		}; 
		public String toString()
		{
			return getFirstMember() +"\n"+ getSecondMember() +"\n"+ getThirdMember() +"\n"+
					getFourthMember() +"\n"+ getFifthMember() +"\n"+ getSixthMember() +"\n"+
					getSeventhMember() +"\n"+ getEigthMember() +"\n"+ getNinthMember()
					+"\n"+ getTenthMember() +"\n"+ getElevenMember() +"\n"+
					getTwelveMember() +"\n"+ getThirteenMember() +"\n"+ getFourteenMember()+"\n"+getFifteenMember()+"\n"+getSixteenMember();






		};
			
}


