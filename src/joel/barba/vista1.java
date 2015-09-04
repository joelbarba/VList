package joel.barba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class vista1 extends Activity {

	static class ViewHolder { CItemView ref_img; } 

	class Adaptador1 extends ArrayAdapter {
	  	   
		Activity context;

        // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.item01,    R.drawable.item02,    R.drawable.item03,
	            R.drawable.item04,    R.drawable.item05,    R.drawable.item06,     
	            R.drawable.item07,    R.drawable.item08,	R.drawable.item09,
	            R.drawable.item10,    R.drawable.item11,	R.drawable.item12,
	            R.drawable.item13,    R.drawable.item14,    R.drawable.item15,
	            R.drawable.item16,    R.drawable.item17,    R.drawable.item18,
	            R.drawable.item19,    R.drawable.item20,    R.drawable.item21,
	            R.drawable.item22,    R.drawable.item23,    R.drawable.item24,
	            R.drawable.item25,    R.drawable.item26,    R.drawable.item27,
	            R.drawable.item28,    R.drawable.item29,    R.drawable.item30,
	            R.drawable.item31,    R.drawable.item32,    R.drawable.item33
	    };			
		
		Adaptador1(Activity context) {
			super(context, R.layout.c_item2, llista);
			this.context = context;
		}

	    public int getCount() { /* Set the number of element we want on the grid */                      
	    	return mThumbIds.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }	    
		
		public int getViewTypeCount() {
		    return 1;
		}	    
	    
		public View getView(int position, View convertView, ViewGroup parent) {

	    	View row = convertView;
	    	ViewHolder holder;

	    	if(row == null) {
				LayoutInflater inflater = context.getLayoutInflater();
				row = inflater.inflate(R.layout.c_item2, parent, false);
		    	holder = new ViewHolder();
	    		holder.ref_img = (CItemView) row.findViewById(R.id.img_item);
		    	row.setTag(holder);
	    	} else {
	    		holder = (ViewHolder) row.getTag();
	    	}
	 
			//CItemView img = (CItemView) row.findViewById(R.id.img_item);
            
			holder.ref_img.text_item = llista[position].nom;
			holder.ref_img.seleccionat = llista[position].sel;
			//img.seleccionat = false;
			//img.refreshDrawableState();

			holder.ref_img.setAdjustViewBounds(true);
			holder.ref_img.setMaxHeight((ControlGrid.getWidth() - 20) / 3);
			holder.ref_img.setMaxWidth((ControlGrid.getWidth() - 20) / 3);
			holder.ref_img.setImageResource(mThumbIds[position]);
   		
			return row;
	
	    }
       
	}    
	    
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) { mContext = c; }
	    public int getCount() { return mThumbIds.length; }
	    public Object getItem(int position) { return null; }
	    public long getItemId(int position) { return 0; }

	    public View getView(int position, View convertView, ViewGroup parent) {
	        CItemView element;
	        if (convertView == null) {
	            element = new CItemView(mContext);
	            element.setLayoutParams(new GridView.LayoutParams(155, 155));
	            element.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            element.setPadding(8, 8, 8, 8);
	        
	        } else {
	        	element = (CItemView) convertView;
	        }

	        element.setImageResource(mThumbIds[position]);
	        element.text_item = llista[position].nom;
	        
	        return element;
	    }

	    private Integer[] mThumbIds = {
	            R.drawable.item01,    R.drawable.item02,    R.drawable.item03,
	            R.drawable.item04,    R.drawable.item05,    R.drawable.item06,     
	            R.drawable.item07,    R.drawable.item08,	R.drawable.item09,
	            R.drawable.item10,    R.drawable.item11,	R.drawable.item12,
	            R.drawable.item13,    R.drawable.item14,    R.drawable.item15,
	            R.drawable.item16,    R.drawable.item17,    R.drawable.item18,
	            R.drawable.item19,    R.drawable.item20,    R.drawable.item21,
	            R.drawable.item22,    R.drawable.item23,    R.drawable.item24,
	            R.drawable.item25,    R.drawable.item26,    R.drawable.item27,
	            R.drawable.item28,    R.drawable.item29,    R.drawable.item30,
	            R.drawable.item31,    R.drawable.item32,    R.drawable.item33
	    };	
	}		

	private CVistaItem[] llista;
	private int num_items;

    private GridView ControlGrid;

    private DataManager DBManager = null;
    
    
	/** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.llista1);

	    carregar_llista(); // Carregar la llista

	    Adaptador1 adp = new Adaptador1(this);
	    //ImageAdapter adp = new ImageAdapter(this);
	    
	    ControlGrid = (GridView) findViewById(R.id.llista_items2);
	    //ControlGrid.setColumnWidth((ControlGrid.getWidth() - 0) / 3);
		ControlGrid.setAdapter(adp);
		
		
		ControlGrid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				
				//Toast.makeText(getApplicationContext(), Long.toString(id), Toast.LENGTH_SHORT).show();

				llista[position].sel = ! llista[position].sel;
				CItemView img = (CItemView) v.findViewById(R.id.img_item);
				img.seleccionat = llista[position].sel;
				//img.refreshDrawableState();
				img.invalidate();
				
			}
        });
		
	    
	}
	
    // Omple l'array de la llista des de DB
    private void carregar_llista() {

	    DBManager = new DataManager(getApplicationContext()); // Crear l'interface amb la DB 
	    DBManager.open();
	    Cursor c = DBManager.get_items(2, 0); 
	    
	    num_items = c.getCount();
	    llista = new CVistaItem[num_items];
	    
	    if (c.moveToFirst()) {
	    	for (int i = 0; i < num_items; i++) {
	    		//llista[i] = new CVistaItem(c.getLong(1), c.getString(2), c.getString(3));
	    		if (! c.moveToNext()) break;
	        } 
 	    }

	    c.close();	    
    	
    }
    

	private void mostrar_avis(String text){   
		Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		toast.show();
	}	
    
	@Override
	protected void onStop() {
		DBManager.close();
		super.onStop();
	}    	
	
}
