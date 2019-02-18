package com.jv_lp_01;

public class Button {
    private String title;
    private OnClickListener onClickListener;

    public Button(String tittle) {
        this.title = tittle;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener (OnClickListener onClickListener){
        this.onClickListener= onClickListener;
    }

    public void onClick(){
        this.onClickListener.onClick(this.title);
    }

    public interface OnClickListener{
        public void onClick(String title);
    }
}
