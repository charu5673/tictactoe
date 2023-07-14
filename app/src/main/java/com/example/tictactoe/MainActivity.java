package com.example.tictactoe;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends Activity implements View.OnClickListener {
    MaterialButton lt,ct,rt,lm,cm,rm,ld,cd,rd;
    TextView sc11;
    TextView sc22;
    TableLayout tl;
    ImageView lti,cti,rti,lmi,cmi,rmi,ldi,cdi,rdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignbId(lt,R.id.lt);
        assignbId(ct,R.id.ct);
        assignbId(rt,R.id.rt);
        assignbId(lm,R.id.lm);
        assignbId(cm,R.id.cm);
        assignbId(rm,R.id.rm);
        assignbId(ld,R.id.ld);
        assignbId(cd,R.id.cd);
        assignbId(rd,R.id.rd);
        lti=findViewById(R.id.lti);
        cti=findViewById(R.id.cti);
        rti=findViewById(R.id.rti);
        lmi=findViewById(R.id.lmi);
        cmi=findViewById(R.id.cmi);
        rmi=findViewById(R.id.rmi);
        ldi=findViewById(R.id.ldi);
        cdi=findViewById(R.id.cdi);
        rdi=findViewById(R.id.rdi);
        sc11=findViewById(R.id.sc1);
        sc22=findViewById(R.id.sc2);
        tl=findViewById(R.id.tableLayout);

    }

    void assignbId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);

    }
    int sc1=0,sc2=0,ltv=0,ctv=0,rtv=0,lmv=0,cmv=0,rmv=0,ldv=0,cdv=0,rdv=0,w=0,t=0;
    public void onClick(View view) {
        Button button = (Button)view;
        String text = button.getText().toString();
        sc11.setText(String.valueOf(sc1));
        sc22.setText(String.valueOf(sc2));
        if(w==1) {
            reset();
            w=0;
        }
        else
        {
            if(text.equals("lt")&&ltv==0)
            {
                ltv=change(lti);
                check();
            }
            else if(text.equals("ct")&&ctv==0)
            {
                ctv=change(cti);
                check();
            }
            else if(text.equals("rt")&&rtv==0)
            {
                rtv=change(rti);
                check();
            }
            else if(text.equals("lm")&&lmv==0)
            {
                lmv=change(lmi);
                check();
            }
            else if(text.equals("cm")&&cmv==0)
            {
                cmv=change(cmi);
                check();
            }
            else if(text.equals("rm")&&rmv==0)
            {
                rmv=change(rmi);
                check();
            }
            else if(text.equals("ld")&&ldv==0)
            {
                ldv=change(ldi);
                check();
            }
            else if(text.equals("cd")&&cdv==0)
            {
                cdv=change(cdi);
                check();
            }
            else if(text.equals("rd")&&rdv==0)
            {
                rdv=change(rdi);
                check();
            }


        }
    }
    int change(ImageView btn)
    {
        int v;
        if(t==0) {
            btn.setBackgroundResource(R.drawable.x2);
            v = 1;
            t=1;
        }
        else {
            btn.setBackgroundResource(R.drawable.o__1_);
            v = 2;
            t=0;
        }
        return(v);
    }
    void reset() {
    ltv=0;
    lti.setBackgroundResource(R.drawable._4x);
    ctv=0;
    cti.setBackgroundResource(R.drawable._4x);
    rtv=0;
    rti.setBackgroundResource(R.drawable._4x);
    lmv=0;
    lmi.setBackgroundResource(R.drawable._4x);
    cmv=0;
    cmi.setBackgroundResource(R.drawable._4x);
    rmv=0;
    rmi.setBackgroundResource(R.drawable._4x);
    ldv=0;
    ldi.setBackgroundResource(R.drawable._4x);
    cdv=0;
    cdi.setBackgroundResource(R.drawable._4x);
    rdv=0;
    rdi.setBackgroundResource(R.drawable._4x);
    tl.setBackgroundResource(R.drawable.gridb);
    t=0;
    w=0;
}
void check()
{
if(ltv==ctv&&ctv==rtv&&rtv!=0)
{
    w=1;
    if(rtv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.ltctrt);
}
else if(lmv==cmv&&rmv==cmv&&cmv!=0)
{
    w=1;
    if(cmv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.lmcmrm);
}
else if(ldv==cdv&&rdv==cdv&&cdv!=0)
{
    w=1;
    if(cdv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.ldcdrd);
}
else if(ltv==lmv&&ldv==lmv&&ldv!=0)
{
    w=1;
    if(ltv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.ltlmld);
}
else if(ctv==cmv&&cdv==cmv&&cdv!=0)
{
    w=1;
    if(ctv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.ctcmcd);
}
else if(rtv==rmv&&rmv==rdv&&rdv!=0)
{
    w=1;
    if(rdv==1)
        sc1+=1;
    else
        sc2+=1;
    tl.setBackgroundResource(R.drawable.rtrmrd);
}
    else if(ltv==cmv&&cmv==rdv&&rdv!=0)
    {
        w=1;
        if(rdv==1)
            sc1+=1;
        else
            sc2+=1;
        tl.setBackgroundResource(R.drawable.ltcmrd);
    }
    else if(rtv==cmv&&cmv==ldv&&ldv!=0)
    {
        w=1;
        if(ldv==1)
            sc1+=1;
        else
            sc2+=1;
        tl.setBackgroundResource(R.drawable.rtcmld);
    }
    else if(rtv!=0&&cmv!=0&&ldv!=0&&ltv!=0&&rdv!=0&&rmv!=0&&ctv!=0&&cdv!=0&&lmv!=0) {
    w = 1;
    tl.setBackgroundResource(R.drawable.gridf);
}
    sc11.setText(String.valueOf(sc1));
    sc22.setText(String.valueOf(sc2));
}

        @Override
        public void onPointerCaptureChanged ( boolean hasCapture){
            super.onPointerCaptureChanged(hasCapture);
        }
    }

