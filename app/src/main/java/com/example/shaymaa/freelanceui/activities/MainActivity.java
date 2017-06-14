package com.example.shaymaa.freelanceui.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.shaymaa.freelance.R;
import com.example.shaymaa.freelanceui.adapters.CategoryAdapter;
import com.example.shaymaa.freelanceui.adapters.ChoiceAdapter;
import com.example.shaymaa.freelanceui.models.Category;
import com.example.shaymaa.freelanceui.models.Choice;
import com.example.shaymaa.freelanceui.onitemclick.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.shaymaa.freelanceui.Utility.Constant.CATEGORY_SELECTED_POSITION;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCategoryRecyclerView;
    private CategoryAdapter mCategoryAdapter;
    private List<Category> mCategoryList;

    private RecyclerView mChoiceRecyclerView;
    private ChoiceAdapter mChoiceAdapter;
    private List<Choice> mChoiceList;
    private ImageView back ,forwerd;
    int  position  ;


    NumberPicker np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back=(ImageView)findViewById(R.id.back);
        forwerd=(ImageView)findViewById(R.id.forword);

        np = (NumberPicker) findViewById(R.id.np);
        np.setWrapSelectorWheel(false);


         // Initialize category list
        mCategoryList=new ArrayList<>();
        mCategoryAdapter=new CategoryAdapter(MainActivity.this,mCategoryList);

        mCategoryRecyclerView = (RecyclerView) findViewById(R.id.category_recycler_view);
        // Enable optimizations if the items are static and will not change for significantly smoother scrolling
        mCategoryRecyclerView.setHasFixedSize(true);

        mCategoryRecyclerView.setActivated(false);
        mCategoryRecyclerView.stopScroll();
        RecyclerView.LayoutManager mCateLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCategoryRecyclerView.setLayoutManager(mCateLayoutManager);

        // If any new item is added, this animation works
        //mCategoryRecyclerView.setItemAnimator(new AKCItemAnimator());
        mCategoryRecyclerView.setAdapter(mCategoryAdapter);
         mCategoryRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

//                        // To reset choice
//                        CHOICE_SELECTED_POSITION=-1;
//



                        // Updating old as well as new positions
                        mCategoryAdapter.notifyItemChanged(CATEGORY_SELECTED_POSITION);
                        CATEGORY_SELECTED_POSITION = position;
                         mCategoryAdapter.notifyItemChanged(CATEGORY_SELECTED_POSITION);
//



                        Category category=mCategoryList.get(position);

                        Toast.makeText(view.getContext(),"Category : "+category.cat_name, Toast.LENGTH_SHORT).show();
                        // Load date in choice recyclerview
//                        pickChoice(position);
                    }
                }));
        // Loading data in category list
        prepareCategory();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mCategoryRecyclerView.scrollBy(70 ,70);

//     ANTHER SELUTION
//                mCategoryRecyclerView.getLayoutManager().scrollToPosition(CATEGORY_SELECTED_POSITION);



            }
        });


        forwerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mCategoryRecyclerView.scrollBy(40 ,40);


            }
        });



    }

    private void prepareCategory(){
        int[] mAccessoryIcon = new int[]{
                R.drawable.category_shirt,
                R.drawable.category_pant,
                R.drawable.category_overcoat,
                R.drawable.category_gown,
                R.drawable.category_hat,
                R.drawable.category_tie,
                R.drawable.category_bride,
                R.drawable.category_handbag,
                R.drawable.category_tees,
                R.drawable.category_shoe,
                R.drawable.category_cutshoe,
        };
        String[] mAccessoryName=getResources().getStringArray(R.array.accessoryName);

        for (int i=0;i<mAccessoryIcon.length;i++){
            Category category=new Category();
            category.cat_id=i;
            category.cat_name=mAccessoryName[i];
            category.cat_icon=mAccessoryIcon[i];
            category.cat_description=mAccessoryName[i]+" details";
            mCategoryList.add(category);
        }
        mCategoryAdapter.notifyDataSetChanged();
    }


//    private void pickChoice(int pos){
//        switch (pos){
//            case CATEGORY_GENDER:
//                prepareGender();
//                break;
//            case CATEGORY_SHIRT:
//                prepareShirt();
//                break;
//            case CATEGORY_PANT:
//                preparePant();
//                break;
//            case CATEGORY_OVERCOAT:
//                prepareOvercoat();
//                break;
//            case CATEGORY_GOWN:
//                prepareGown();
//                break;
//            case CATEGORY_HAT:
//                prepareHat();
//                break;
//            case CATEGORY_TIE:
//                prepareTie();
//                break;
//            case CATEGORY_BRIDE:
//                prepareBride();
//                break;
//            case CATEGORY_HANDBAG:
//                prepareHandbag();
//                break;
//            case CATEGORY_TEES:
//                prepareTees();
//                break;
//            case CATEGORY_SHOE:
//                prepareShoe();
//                break;
//            case CATEGORY_CUTSHOE:
//                prepareCutshoe();
//                break;
//        }
//    }

//    private void prepareGender(){
//        if(mChoiceList.size()>0) mChoiceList.clear();
//
//        Choice choiceBoy=new Choice();
//        choiceBoy.choice_id=1;
//        choiceBoy.choice_name="BOY";
//        choiceBoy.choice_icon=R.drawable.boy;
//        choiceBoy.choice_description="Gender - BOY";
//        mChoiceList.add(choiceBoy);
//
//        Choice choiceGirl=new Choice();
//        choiceGirl.choice_id=2;
//        choiceGirl.choice_name="Girl";
//        choiceGirl.choice_icon=R.drawable.girl;
//        choiceGirl.choice_description="Gender - Girl";
//        mChoiceList.add(choiceGirl);
//
//        mChoiceAdapter.notifyDataSetChanged();
//    }


    private void prepareShirt(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<5;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Shirt "+j;
            choice.choice_icon=R.drawable.category_shirt;
            choice.choice_description="Shirt choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void preparePant(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<8;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Pant "+j;
            choice.choice_icon=R.drawable.category_pant;
            choice.choice_description="Pant choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareOvercoat(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<3;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Overcoat "+j;
            choice.choice_icon=R.drawable.category_overcoat;
            choice.choice_description="Overcoat choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareGown(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<6;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Gown "+j;
            choice.choice_icon=R.drawable.category_gown;
            choice.choice_description="Gown choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareHat(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<8;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Hat "+j;
            choice.choice_icon=R.drawable.category_hat;
            choice.choice_description="Hat choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareTie(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<10;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Tie "+j;
            choice.choice_icon=R.drawable.category_tie;
            choice.choice_description="Tie choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareBride(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<3;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Bride "+j;
            choice.choice_icon=R.drawable.category_bride;
            choice.choice_description="Bride choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareHandbag(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<5;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Handbag "+j;
            choice.choice_icon=R.drawable.category_handbag;
            choice.choice_description="Handbag choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareTees(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<4;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Tees "+j;
            choice.choice_icon=R.drawable.category_tees;
            choice.choice_description="Tees choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareShoe(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<10;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Shoe "+j;
            choice.choice_icon=R.drawable.category_shoe;
            choice.choice_description="Shoe choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }

    private void prepareCutshoe(){
        if(mChoiceList.size()>0) mChoiceList.clear();

        for (int j=1;j<5;j++){
            Choice choice=new Choice();
            choice.choice_id=j;
            choice.choice_name="Cutshoe "+j;
            choice.choice_icon=R.drawable.category_cutshoe;
            choice.choice_description="Cutshoe choices";
            mChoiceList.add(choice);
        }
        mChoiceAdapter.notifyDataSetChanged();
    }
}
