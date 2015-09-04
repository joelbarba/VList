package joel.barba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataManager {

	private DataBaseSQLiteHelper mHelper = null;
	private SQLiteDatabase db = null;

	public DataManager(final Context context) {
		this.mHelper = new DataBaseSQLiteHelper(context); 
	}

	// Obre la base de dades i retorna la instància
	public DataManager open() {
		db = this.mHelper.getWritableDatabase();
		return this;
	}

	// Tanca la base de dades i allibera els recursos
	public void close() {
		if(db != null) { db.close(); }
	}

	public void ini_db(boolean reload) {

		
		if ((reload) || (db.rawQuery("SELECT 1 FROM items_llistes", null).getCount() == 0)) {
		
			db.execSQL("DELETE FROM llistes");
			db.execSQL("INSERT INTO llistes (id_llista, nom, descripcio) VALUES (1, 'compra mercadona', '')");
			db.execSQL("INSERT INTO llistes (id_llista, nom, descripcio) VALUES (2, 'compra carrefour', '')");
			db.execSQL("INSERT INTO llistes (id_llista, nom, descripcio) VALUES (3, 'compra decathlon', '')");
	
			db.execSQL("DELETE FROM items");

			db.execSQL("INSERT INTO items VALUES (1, 'Taronges', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (2, 'Tomàquet pa', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (3, 'Tomàquet amanida', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (4, 'Amanida', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (5, 'Arròs pre', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (6, 'Mongeta verda', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (7, 'Patates fregides', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (8, 'Ous', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (9, 'Fuet', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (10, 'Xoriço', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (11, 'Pernil', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (12, 'Salami', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (13, 'Pernil dolç', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (14, 'Tacos pernil dolç', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (15, 'Mortadela', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (16, 'Catalana', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (17, 'Tranchetes', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (18, 'Formatge ratllat', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (19, 'Formatge cabra', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (20, 'Frankfurts', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (21, 'Xistorra', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (22, 'Salmó', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (23, 'Carbonara', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (24, 'Peix', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (25, 'Carn', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (26, 'Pizza', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (27, 'Quicos', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (28, 'Sabó dutxa', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (29, 'Xampú', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (30, 'Pa bimbo', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (31, 'Yogur coco', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (32, 'Yogur llimona', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (33, 'Yogur fresa', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (34, 'Yogur macedonia', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (35, 'Cereals', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (36, 'Naquis', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (37, 'Estrella Damm', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (38, 'Voll Damm', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (39, 'Aigua', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (40, 'Coca-cola', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (41, 'Fanta llimona', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (42, 'Oli oliva', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (43, 'Oli fregir', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (44, 'Vinagre', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (45, 'Tomàquet solis', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (46, 'Ketchup', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (47, 'Pinya almívar', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (48, 'Préssec almívar', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (49, 'Élises', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (50, 'Espaguetis', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (51, 'Arròs normal', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (52, 'Llenties pot', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (53, 'Mongetes pot', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (54, 'Olives normals', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (55, 'Olives negres', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (56, 'Paper cuina', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (57, 'Paper water', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (58, 'Bosses basura 1', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (59, 'Bosses basura 2', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (60, 'Paper plata', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (61, 'Detergent', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (62, 'Suavitzant', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (63, 'Pastilles rentaplats', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (64, 'Pasta dents', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (65, 'Pa entrepans', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (66, 'Tè', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (67, 'Desengrassant', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (68, 'Patates', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (69, 'Pepino', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (70, 'Ceba', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (71, 'Plàtan', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (72, 'Poma', '', '', 0)");
			db.execSQL("INSERT INTO items VALUES (73, 'Mandarina', '', '', 0)");

	
			db.execSQL("DELETE FROM items_llistes");
			db.execSQL("INSERT INTO items_llistes VALUES (1, 2, 10, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (2, 2, 20, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (3, 2, 30, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (4, 2, 40, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (5, 2, 50, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (6, 2, 60, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (7, 2, 70, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (8, 2, 80, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (9, 2, 90, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (10, 2, 100, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (11, 2, 110, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (12, 2, 120, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (13, 2, 130, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (14, 2, 140, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (15, 2, 150, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (16, 2, 160, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (17, 2, 170, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (18, 2, 180, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (19, 2, 190, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (20, 2, 200, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (21, 2, 210, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (22, 2, 220, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (23, 2, 230, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (24, 2, 240, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (25, 2, 250, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (26, 2, 260, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (27, 2, 270, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (28, 2, 280, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (29, 2, 290, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (30, 2, 300, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (31, 2, 310, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (32, 2, 320, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (33, 2, 330, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (34, 2, 340, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (35, 2, 350, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (36, 2, 360, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (37, 2, 370, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (38, 2, 380, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (39, 2, 390, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (40, 2, 400, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (41, 2, 410, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (42, 2, 420, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (43, 2, 430, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (44, 2, 440, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (45, 2, 450, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (46, 2, 460, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (47, 2, 470, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (48, 2, 480, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (49, 2, 490, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (50, 2, 500, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (51, 2, 510, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (52, 2, 520, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (53, 2, 530, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (54, 2, 540, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (55, 2, 550, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (56, 2, 560, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (57, 2, 570, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (58, 2, 580, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (59, 2, 590, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (60, 2, 600, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (61, 2, 610, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (62, 2, 620, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (63, 2, 630, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (64, 2, 640, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (65, 2, 650, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (66, 2, 660, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (67, 2, 670, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (68, 2, 680, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (69, 2, 690, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (70, 2, 700, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (71, 2, 710, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (72, 2, 720, 0)");
			db.execSQL("INSERT INTO items_llistes VALUES (73, 2, 730, 0)");

			
		}
		
	}
	
	// Retorna totes les llistes
	public Cursor get_llistes() {
		return db.rawQuery("SELECT ROWID _id, id_llista, nom, descripcio FROM llistes", null);
	}
	
	// Retorna tots els ítems d'una llista, en la selecció num_sel
	public Cursor get_items(long id_llista, long num_sel) {
		
		return db.rawQuery("SELECT t1.ROWID _id,      " +
                           "       t1.id_item,        " +
                           "       t1.nom,            " +
                           "       t1.imatge,         " +
                           "       t2.nivell_seleccio " +
				           "  FROM items         t1,  " +
				           "       items_llistes t2   " +
				           " WHERE t1.id_item   = t2.id_item " +
				           "   AND t2.id_llista = " + id_llista +
                           "   AND t2.nivell_seleccio >= " + num_sel +
				           " ORDER BY t2.ordre", 
				           null);
	}
	
	public boolean marcar_nivell_item(long id_llista, long id_item, long nivell) {
       db.execSQL("update items_llistes " +
                  "   set nivell_seleccio = " + nivell +
                  " where id_item   = " + id_item +
                  "   and id_llista = " + id_llista
       );
     
       return true;
    }

}