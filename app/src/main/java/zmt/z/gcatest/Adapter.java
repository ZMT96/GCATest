package zmt.z.gcatest;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import zmt.z.gcatest.model.Rates;

public class Adapter extends RecyclerView.Adapter<Adapter.PlaceHolder>  {
    Context context;
    ArrayList<Rates> arrayList;

    public Adapter(Context context, ArrayList<Rates> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.PlaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_layout,viewGroup,false);
        PlaceHolder placeHolder=new PlaceHolder(v);
        return placeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.PlaceHolder placeHolder, int i) {
        placeHolder.usd.setText(arrayList.get(i).getUSD());
        placeHolder.rub.setText(arrayList.get(i).getRUB());
        placeHolder.kwd.setText(arrayList.get(i).getKWD());
        placeHolder.inr.setText(arrayList.get(i).getINR());
        placeHolder.bnd.setText(arrayList.get(i).getBND());
        placeHolder.eur.setText(arrayList.get(i).getEUR());
        placeHolder.chf.setText(arrayList.get(i).getCHF());
        placeHolder.zar.setText(arrayList.get(i).getZAR());
        placeHolder.npr.setText(arrayList.get(i).getNPR());
        placeHolder.cny.setText(arrayList.get(i).getCNY());
        placeHolder.kes.setText(arrayList.get(i).getKES());
        placeHolder.egp.setText(arrayList.get(i).getEGP());
        placeHolder.bdt.setText(arrayList.get(i).getBDT());
        placeHolder.thb.setText(arrayList.get(i).getTHB());
        placeHolder.pkr.setText(arrayList.get(i).getPKR());
        placeHolder.sar.setText(arrayList.get(i).getSAR());
        placeHolder.lak.setText(arrayList.get(i).getLAK());
        placeHolder.idr.setText(arrayList.get(i).getIDR());
        placeHolder.khr.setText(arrayList.get(i).getKHR());
        placeHolder.sgd.setText(arrayList.get(i).getSGD());
        placeHolder.jpy.setText(arrayList.get(i).getJPY());
        placeHolder.lkr.setText(arrayList.get(i).getLKR());
        placeHolder.nzd.setText(arrayList.get(i).getNZD());
        placeHolder.czk.setText(arrayList.get(i).getCZK());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder {
        TextView usd,rub,kwd,inr,bnd,eur,chf,zar,npr,cny,kes,egp,bdt,thb,pkr,sar,lak,idr,khr,sgd,jpy,lkr,nzd,czk;
        public PlaceHolder(@NonNull View itemView) {
            super(itemView);
            usd=itemView.findViewById(R.id.usd);
            rub=itemView.findViewById(R.id.rub);
            kwd=itemView.findViewById(R.id.kwd);
            inr=itemView.findViewById(R.id.inr);
            bnd=itemView.findViewById(R.id.bnd);
            eur=itemView.findViewById(R.id.eur);
            chf=itemView.findViewById(R.id.chf);
            zar=itemView.findViewById(R.id.zar);
            npr=itemView.findViewById(R.id.npr);
            cny=itemView.findViewById(R.id.cny);
            kes=itemView.findViewById(R.id.kes);
            egp=itemView.findViewById(R.id.egp);
            bdt=itemView.findViewById(R.id.bdt);
            thb=itemView.findViewById(R.id.thb);
            pkr=itemView.findViewById(R.id.pkr);
            sar=itemView.findViewById(R.id.sar);
            lak=itemView.findViewById(R.id.lak);
            idr=itemView.findViewById(R.id.idr);
            khr=itemView.findViewById(R.id.khr);
            sgd=itemView.findViewById(R.id.sgd);
            jpy=itemView.findViewById(R.id.jpy);
            lkr=itemView.findViewById(R.id.lkr);
            nzd=itemView.findViewById(R.id.nzd);
            czk=itemView.findViewById(R.id.czk);
        }
    }
}
