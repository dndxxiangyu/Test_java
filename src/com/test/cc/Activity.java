package com.test.cc;

public class Activity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Button button = new Button();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void OnClick(Button b) {
				System.out.println("clicked");
			}
		});

	}

}
interface OnClickListener {
	   
    public void OnClick(Button b);
 
}

class Button{
	OnClickListener listener;
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
}