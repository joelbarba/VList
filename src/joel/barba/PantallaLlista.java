package joel.barba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.AdapterView.OnItemClickListener;

public class PantallaLlista extends Activity {

	private ViewFlipper vf;
	private Animation flip_in_from_left, flip_in_from_right, flip_out_to_left, flip_out_to_right;
	private final Point pos_ini_touch = new Point();
	private boolean ani_left_on = false;
	private boolean ani_rigth_on = false;
	private int distancia_touch = 0;
	private final int MIN_DISTANCIA_TOUCH = 40;
	private TextView titol_llista;

    private int nivell_llista = 0;
    private int id_llista = 2;
    private int nivell_max = 0;
    private int num_seleccionats = 0;

	static class ViewHolder { CItemView ref_img; } 

	class Adaptador1 extends ArrayAdapter {
	  	   
		Activity context;

        // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.item01,	R.drawable.item02,	R.drawable.item03,	R.drawable.item04,    
	            R.drawable.item05,	R.drawable.item06,	R.drawable.item07,	R.drawable.item08,	
	            R.drawable.item09,	R.drawable.item10,	R.drawable.item11,	R.drawable.item12,
	            R.drawable.item13,	R.drawable.item14,	R.drawable.item15,	R.drawable.item16,
	            R.drawable.item17,	R.drawable.item18,	R.drawable.item19,	R.drawable.item20,
	            R.drawable.item21,	R.drawable.item22,	R.drawable.item23,	R.drawable.item24,
	            R.drawable.item25,	R.drawable.item26,	R.drawable.item27,	R.drawable.item28,
	            R.drawable.item29,	R.drawable.item30,	R.drawable.item31,	R.drawable.item32,
	            R.drawable.item33,	R.drawable.item34,	R.drawable.item35,	R.drawable.item36,
	            R.drawable.item37,	R.drawable.item38,	R.drawable.item39,	R.drawable.item40,
	            R.drawable.item41,	R.drawable.item42,	R.drawable.item43,	R.drawable.item44,
	            R.drawable.item45,	R.drawable.item46,	R.drawable.item47,	R.drawable.item48,
	            R.drawable.item49,	R.drawable.item50,	R.drawable.item51,	R.drawable.item52,
	            R.drawable.item53,	R.drawable.item54,	R.drawable.item55,	R.drawable.item56,
	            R.drawable.item57,	R.drawable.item58,	R.drawable.item59,	R.drawable.item60,
	            R.drawable.item61,	R.drawable.item62,	R.drawable.item63,	R.drawable.item64,
	            R.drawable.item65,	R.drawable.item66,	R.drawable.item67,	R.drawable.item68,
	            R.drawable.item69,	R.drawable.item70,	R.drawable.item71,	R.drawable.item72,
	            R.drawable.item73
	    };			
		
		Adaptador1(Activity context) {
			super(context, R.layout.c_item2, llista);
			this.context = context;
		}

	    public int getCount() { /* Set the number of element we want on the grid */                      
	    	//return mThumbIds.length;
	    	//return llista.length;
	    	return count_elements_nivell();
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
	 
	    	CVistaItem element = llista[position];
	    	
	    	int t = 0;
	    	int i;
	    	for (i = 0; i < num_items; i++) {
	    		if (llista[i].nivell_sel >= nivell_llista) t++;
	    		if (t > position) {
	    			element = llista[i];
	    			break;
	    		}
	        }	    	
            
			//holder.ref_img.text_item = element.nom + " - " + element.nivell_sel + " - " + i;
			holder.ref_img.text_item = element.nom;
			holder.ref_img.seleccionat = (element.nivell_sel > nivell_llista);

			holder.ref_img.setAdjustViewBounds(true);
			holder.ref_img.setMaxHeight((ControlGrid.getWidth() - 20) / 3);
			holder.ref_img.setMaxWidth((ControlGrid.getWidth() - 20) / 3);
			holder.ref_img.setImageResource(mThumbIds[(int) element.id_item - 1]);
   		
			return row;
	
	    }
       
	}    
	
	/*
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
	        element.text_item = llista[position].nom + " - " + llista[position].nivell_sel;
	        
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
	*/

	private CVistaItem[] llista;
	private int num_items;

    private GridView ControlGrid;
    private GridView ControlGrid2;

    private DataManager DBManager = null;	
    
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.pantalla_llista);

	    
		vf = (ViewFlipper)findViewById(R.id.main_flipper);
		
		flip_in_from_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_in_from_left);
		flip_in_from_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_in_from_right);
		flip_out_to_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_out_to_left);
		flip_out_to_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_out_to_right);
		
		titol_llista = (TextView) findViewById(R.id.titol_llista);
		
		flip_in_from_left.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) { ani_left_on = true; }           
		    @Override
		    public void onAnimationEnd(Animation arg0) { ani_left_on = false; pos_ini_touch.x = -1; }
			@Override
			public void onAnimationRepeat(Animation animation) { }
		});
		
		flip_in_from_right.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) { ani_rigth_on = true; }           
		    @Override
		    public void onAnimationEnd(Animation arg0) { ani_rigth_on = false; pos_ini_touch.x = -1; }
			@Override
			public void onAnimationRepeat(Animation animation) { }
		});		

		final ImageView fletxa1 = (ImageView)findViewById(R.id.canvi_llista_dreta);
		final ImageView fletxa2 = (ImageView)findViewById(R.id.canvi_llista_esquerra);
		
	    carregar_llista(); // Carregar la llista
	    
	    
	    // Inicialitzar elements
    	titol_llista.setText("llista = " + nivell_llista + "; max = " + nivell_max + "; el = " + count_elements_nivell());
        setTitle("llista " + nivell_llista);
        if (nivell_llista > 0) 			{ fletxa2.setAlpha(255); } else { fletxa2.setAlpha(50); }
        if (nivell_llista < nivell_max) { fletxa1.setAlpha(255); } else { fletxa1.setAlpha(50); }
        

        
	    Adaptador1 adp = new Adaptador1(this);
	    //ImageAdapter adp = new ImageAdapter(this);
	    
	    ControlGrid = (GridView) findViewById(R.id.llista_items2);
	    //ControlGrid.setColumnWidth((ControlGrid.getWidth() - 0) / 3);
		ControlGrid.setAdapter(adp);
		
		ControlGrid2 = (GridView) findViewById(R.id.llista_items3);
		ControlGrid2.setAdapter(adp);
		
		
		ControlGrid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				
				//Toast.makeText(getApplicationContext(), Long.toString(id), Toast.LENGTH_SHORT).show();

				seleccionar_item(position);

				CItemView img = (CItemView) v.findViewById(R.id.img_item);
				img.seleccionat = llista[position].sel;
				//img.text_item = llista[position].nom + "-" + llista[position].nivell_sel;

				//img.refreshDrawableState();
				img.invalidate();

		        if (nivell_llista > 0) 			{ fletxa2.setAlpha(255); } else { fletxa2.setAlpha(50); }
		        if (nivell_llista < nivell_max) { fletxa1.setAlpha(255); } else { fletxa1.setAlpha(50); }
		        
		        ControlGrid2.invalidateViews();
		        
				
			}
        });
        
		ControlGrid2.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				
				//seleccionar_item(position);

				CItemView img = (CItemView) v.findViewById(R.id.img_item);
				img.seleccionat = !img.seleccionat;
				img.invalidate();

		        if (nivell_llista > 0) 			{ fletxa2.setAlpha(255); } else { fletxa2.setAlpha(50); }
		        if (nivell_llista < nivell_max) { fletxa1.setAlpha(255); } else { fletxa1.setAlpha(50); }
			
			}
        });
		
		
		fletxa1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

                if (nivell_llista < nivell_max) {

                	nivell_llista++;
                	titol_llista.setText("llista " + nivell_llista);
                    setTitle("llista " + nivell_llista);

            		vf.setInAnimation(flip_in_from_right);
            		vf.setOutAnimation(flip_out_to_left);
                	vf.showNext();

                	if (nivell_llista > 0) { fletxa2.setAlpha(255); }
                	if (nivell_llista == nivell_max) { fletxa1.setAlpha(50); }
                	else { fletxa1.setAlpha(255); }

        	    	for (int i = 0; i < num_items; i++) {
                        if (llista[i].nivell_sel > nivell_llista) { llista[i].sel = true; } 
                        else { llista[i].sel = false; }
        	        }

        	    	titol_llista.setText("llista = " + nivell_llista + "; max = " + nivell_max + "; el = " + count_elements_nivell());
        	    	
                }

			}
		});

		fletxa2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

                
                if (nivell_llista > 0) {

                    nivell_llista--;

	            	titol_llista.setText("llista " + nivell_llista);
	            	setTitle("llista " + nivell_llista);
	
	        		vf.setInAnimation(flip_in_from_left);
	        		vf.setOutAnimation(flip_out_to_right);
	        		vf.showPrevious();

	        		if (nivell_llista < nivell_max) { fletxa1.setAlpha(255); }
                	if (nivell_llista == 0) { fletxa2.setAlpha(50); }
                	else { fletxa2.setAlpha(255); }

        	    	for (int i = 0; i < num_items; i++) {
                        if (llista[i].nivell_sel > nivell_llista) { llista[i].sel = true; } 
                        else { llista[i].sel = false; }
        	        }
        	    	titol_llista.setText("llista = " + nivell_llista + "; max = " + nivell_max + "; el = " + count_elements_nivell());
                }
            }

		});

		/*
		ControlGrid.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) { 
				return slide_pantalla(v, event);
			} 
		});

		ControlGrid2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) { 
				return slide_pantalla(v, event);
			} 
		});*/
		
		
    }

	private void seleccionar_item(int i) {
		
        llista[i].sel = ! llista[i].sel;

        if (llista[i].sel) {
        	DBManager.marcar_nivell_item(id_llista,
                               llista[i].id_item,
                               nivell_llista + 1);
            num_seleccionats++;
            llista[i].nivell_sel++;
            if (nivell_max < nivell_llista + 1) { nivell_max = nivell_llista + 1; }
        } else {
        	DBManager.marcar_nivell_item(id_llista,
                               llista[i].id_item,
                               nivell_llista);
            num_seleccionats--;
            if (num_seleccionats == 0) { nivell_max = nivell_llista; }
            llista[i].nivell_sel--;
        }			
	}    
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) { return slide_pantalla(null, event); }
    
    
	boolean slide_pantalla(View v, MotionEvent event) {
    	if(event.getAction() == MotionEvent.ACTION_DOWN) {
    		// inici pulsació
    		if ((!ani_left_on) && (!ani_rigth_on)) {
    			pos_ini_touch.x = (int)event.getX();
    		}
	        return true;

    	} else if(event.getAction() == MotionEvent.ACTION_MOVE) {
	    	// moviment de la pulsació

    		if (pos_ini_touch.x == -1) {
    			pos_ini_touch.x = (int)event.getX(); distancia_touch = 0;
    		} else {
    			distancia_touch = (int)event.getX() - pos_ini_touch.x;
    		}
    		
	    	if ((!ani_left_on) && (!ani_rigth_on)) {

	            if (Math.abs(distancia_touch) > MIN_DISTANCIA_TOUCH) {
	                if (distancia_touch > 0) {
	            		vf.setInAnimation(flip_in_from_left);
	            		vf.setOutAnimation(flip_out_to_right);
	            		vf.showPrevious();
	                } else {
	            		vf.setInAnimation(flip_in_from_right);
	            		vf.setOutAnimation(flip_out_to_left);
	                	vf.showNext();
                	}
	                titol_llista.setText("llista "+vf.getDisplayedChild());
	                pos_ini_touch.x = (int)event.getX();
	        	}
            }
            return true;

    	} else if(event.getAction() == MotionEvent.ACTION_UP) {
    		titol_llista.setText("apretant");
    		//v.performClick();
    		return true;
	    } else {
	    	return false;
		}
	}    
    
/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

    	if(event.getAction() == MotionEvent.ACTION_DOWN) {
    		// inici pulsació
    		if ((!ani_left_on) && (!ani_rigth_on)) {
    			pos_ini_touch.x = (int)event.getX();
    		}
    		titol_llista.setText("waka");
	        return true;

    	} else if(event.getAction() == MotionEvent.ACTION_MOVE) {
	    	// moviment de la pulsació

    		if (pos_ini_touch.x == -1) {
    			pos_ini_touch.x = (int)event.getX();
    			distancia_touch = 0;
    		} else {
    			distancia_touch = (int)event.getX() - pos_ini_touch.x;
    		}
    		

	    	if ((!ani_left_on) && (!ani_rigth_on)) {

	            if (Math.abs(distancia_touch) > MIN_DISTANCIA_TOUCH) {
	                if (distancia_touch > 0) {
	            		vf.setInAnimation(flip_in_from_left);
	            		vf.setOutAnimation(flip_out_to_right);
	                } else {
	            		vf.setInAnimation(flip_in_from_right);
	            		vf.setOutAnimation(flip_out_to_left);
	                	vf.showNext();
	            		vf.showPrevious();
                	}
	                titol_llista.setText("llista "+vf.getDisplayedChild());
	                pos_ini_touch.x = (int)event.getX();
	        	}
            }
            
            return true;
            
	    } else if(event.getAction() == MotionEvent.ACTION_UP) {
	    	// final de la pulsació
            return true;
        } else {
            return super.onTouchEvent(event);
        }
    }
*/
	
    // Omple l'array de la llista des de DB
    private void carregar_llista() {

	    DBManager = new DataManager(getApplicationContext()); // Crear l'interface amb la DB 
	    DBManager.open();
	    Cursor c = DBManager.get_items(id_llista, nivell_llista);
	    
	    num_items = c.getCount();
	    llista = new CVistaItem[num_items];
	    
	    if (c.moveToFirst()) {
	    	for (int i = 0; i < num_items; i++) {
	    		llista[i] = new CVistaItem(c.getLong(1), c.getString(2), c.getString(3), c.getLong(4));

                // Si el nivell de selecció és major, marcar-lo seleccionat
                if (llista[i].nivell_sel > nivell_llista) { llista[i].sel = true; }
                
                // Assigna inicialment el màxim nivell possible
                if (llista[i].nivell_sel > nivell_max) { nivell_max = (int) c.getLong(4); }

	    		if (! c.moveToNext()) break;
	        } 
 	    }

	    c.close();	    
    	
    }
    
    private int count_elements_nivell() {
    	int elements_nivell = 0;
    	for (int i = 0; i < num_items; i++) {
    		if (llista[i].nivell_sel >= nivell_llista) elements_nivell++;   
        }
    	return elements_nivell;
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
