package ehh.jahangostar.com.realm;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by EHH on 2018/04/07.
 */

public class PersonDetailsAdapter extends BaseAdapter {
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    ArrayList<PersonDetailsModel> personDetailsArrayList;

    public PersonDetailsAdapter(Context context,ArrayList<PersonDetailsModel> personDetailsArrayList) {
        super();
        this.personDetailsArrayList = personDetailsArrayList;
    }

    @Override

    public int getCount() {
        return 0;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        UserHolder holder=null;
        holder.tvPersonName = (TextView) v.findViewById(R.id.tv_Name);
        holder.ivEditPesonDetail = (ImageView) v.findViewById(R.id.iv_Edit);
        holder.ivDeletePerson = (ImageView) v.findViewById(R.id.iv_Delete);
      //  holder.tvPersonName.setText(personDetailsArrayList.get(position).getName());
        holder.ivEditPesonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  PersonDetailsModel dataToEditModel = MainActivity.getInstance().searchPerson(personDetailsArrayList.get(position).getId());
             //   MainActivity.getInstance().addOrUpdatePersonDetailsDialog(dataToEditModel, position);
            }
        });
        holder.ivDeletePerson.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              //  ShowConfirmDialog(context, personDetailsArrayList.get(position).getId(), position);
            }
        });
        return v;
    }

    public static void ShowConfirmDialog(Context context, final int personId, final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage("Are you sure you want to delete this record?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       // MainActivity.getInstance().deletePerson(personId, position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

   static class UserHolder {
        TextView tvPersonName;
        ImageView ivEditPesonDetail;
        ImageView ivDeletePerson;

    }
}
