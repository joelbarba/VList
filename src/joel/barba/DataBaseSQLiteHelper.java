package joel.barba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseSQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "DBVList";
	private static final int DATABASE_VERSION = 3;
	
    // Definició de la base de dades
    String sent_create_llistes = "CREATE TABLE llistes (" + 
    "id_llista    LONG," +
    "nom          TEXT," +
    "descripcio   TEXT," +
    "PRIMARY KEY (id_llista))";

    String sent_create_items = "CREATE TABLE items (" +
    "id_item      LONG," +
    "nom          TEXT," +
    "descripcio   TEXT," +
    "imatge       TEXT," +
    "preu         INTEGER," +
    "PRIMARY KEY (id_item))";
    
    String sent_create_items_llistes = "CREATE TABLE items_llistes (" +
    "id_item         LONG," +
    "id_llista       LONG," +
    "ordre           LONG," +
    "nivell_seleccio LONG," +
    "PRIMARY KEY (id_item, id_llista))";
    
    
    public DataBaseSQLiteHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sent_create_llistes);
        db.execSQL(sent_create_items);
        db.execSQL(sent_create_items_llistes);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {

    	// Si s'ha canviat de versió, actualitza i exporta les dades
    	db.execSQL("drop table llistes");
    	db.execSQL("drop table items");
    	db.execSQL("drop table items_llistes");

    	db.execSQL(sent_create_llistes);
        db.execSQL(sent_create_items);
        db.execSQL(sent_create_items_llistes);

    }
}
