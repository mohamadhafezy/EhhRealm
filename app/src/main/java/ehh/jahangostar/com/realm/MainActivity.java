package ehh.jahangostar.com.realm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Realm myRealm;
    private ListView lv_PersonName;
    PersonDetailsAdapter personDetailsAdapter;
    ArrayList<PersonDetailsModel> personDetailsModelArrayList=new ArrayList<PersonDetailsModel>();
    static int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRealm = Realm.getInstance(this);
        lv_PersonName = (ListView) findViewById(R.id.listView_PersonName);
        personDetailsAdapter = new PersonDetailsAdapter(this, personDetailsModelArrayList);
        lv_PersonName.setAdapter(personDetailsAdapter);


    }
    private void addDataToRealm(PersonDetailsModel model)
    {
        PersonDetailsModel personDetailsModel = myRealm.createObject(PersonDetailsModel.class);
        personDetailsModel.setId(id);
        personDetailsModel.setName(model.getName());
        personDetailsModel.setEmail(model.getEmail());
        personDetailsModel.setAddress(model.getAddress());
        personDetailsModel.setAge(model.getAge());
        personDetailsModelArrayList.add(personDetailsModel);
        myRealm.commitTransaction();
        personDetailsAdapter.notifyDataSetChanged();
        myRealm.beginTransaction();
        id++;
        personDetailsAdapter.notifyDataSetChanged();
    }
    public void add(View view){
        View alertLayout = getLayoutInflater().inflate(R.layout.details_dialog, null);
        final EditText etname = (EditText) alertLayout.findViewById(R.id.et_Name);
        final EditText etEmail = (EditText) alertLayout.findViewById(R.id.et_Email);
        final EditText etAddress = (EditText) alertLayout.findViewById(R.id.et_Address);
        final EditText etAge = (EditText) alertLayout.findViewById(R.id.et_Age);

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNeutralButton("انصراف", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "کنسل شد", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setPositiveButton("ثبت", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //  setEditeText(etbarcode, etnamegood, etpricbuygood, etpricsellgood, numbergood);
                String name = etname.getText().toString();
                String Address = etAddress.getText().toString();
                String Email = etEmail.getText().toString();
                String Age=etAge.getText().toString();
                PersonDetailsModel model=new PersonDetailsModel();
                model.setName(name);
                model.setAddress(Address);
                model.setEmail(Email);
                model.setAge(Integer.parseInt(Age));
                addDataToRealm(model);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }
}
