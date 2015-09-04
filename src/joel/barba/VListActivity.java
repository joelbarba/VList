package joel.barba;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class VListActivity extends Activity {

    private ListView llista1;

    private DataManager DBManager = null;
    private Cursor cursor = null;
    private long selectedId = -1;    
    
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	    //configurar_components(); // Configurar els controls gràfics

	    DBManager = new DataManager(getApplicationContext()); // Crear l'interface amb la DB 
	    DBManager.open();
	    DBManager.ini_db(false);
	    
	    actualitzar_llista(); // Carregar la llista

	    /// SALTAR DIRECTAMENT A VISTA1
		Intent i = new Intent(VListActivity.this, PantallaLlista.class);
		//startActivity(i);
	    
		
		ImageView img = (ImageView)findViewById(R.id.icona_reload); img.setImageResource(R.drawable.reload);

		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				DBManager.ini_db(true);
				mostrar_avis("S'ha eliminat tot el contingut de la base de dades, i recarregat l'original per defecte");
			}
		});
		
	}
	
	private void actualitzar_llista(){
		
		cursor = DBManager.get_llistes();
		startManagingCursor(cursor); // indicar a l'activity que s'encarregui de la gestió dels recursos del cursor

		// crear l'adaptador
		String[] from = new String[]{ "id_llista", "nom", "descripcio" };
		int[] to = new int[] { R.id.etq_id, R.id.etq_nom, R.id.etq_descripcio };
		 
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.c_item1, cursor, from, to);

		llista1 = (ListView) findViewById(R.id.llista_llistes); // recuperar la llista
		llista1.setItemsCanFocus(true);
		llista1.setAdapter(adapter);			

		
        llista1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				selectedId=id;
				//tv_sel.setText("element seleccionat == "+selectedId);
				llista1.requestFocus();
				llista1.setSelection(position);
				v.setBackgroundColor(0x0000FF00);
				//Intent i = new Intent(VListActivity.this, vista1.class);
				Intent i = new Intent(VListActivity.this, PantallaLlista.class);
				startActivity(i);

			}
        });
		/*
		llista1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				selectedId = arg3;
				//tv_sel.setText("element seleccionat = "+selectedId);
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				//selectedId = -1;
				//tv_sel.setText("element seleccionat = cap");
			}
		});*/
	}	
	

	private void refrescar_llista() {
		 cursor.requery(); 
	} 

	private void mostrar_avis(String text){   
		Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		toast.show();
	}	
    
	@Override
	protected void onStop() {
		//DBManager.close();
		super.onStop();
	}    
    
}