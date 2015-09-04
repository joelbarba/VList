package joel.barba;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class CItemView extends ImageView {

	public CItemView(Context context, AttributeSet attrs, int defStyle) { super(context, attrs,defStyle); inicialitzar(); }
	public CItemView(Context context, AttributeSet attrs) {	super(context, attrs); inicialitzar(); }
	public CItemView(Context context) {	super(context); inicialitzar(); }
	
	public String text_item = "";
	public boolean seleccionat = false;
	
	
	private Paint p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Paint p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Paint p3 = new Paint(Paint.ANTI_ALIAS_FLAG);

	
	private void inicialitzar() {

		text_item = "item";
		seleccionat = false;

	}


	@Override
	public void onDraw(Canvas canvas) {

		
		p1.setColor(Color.rgb(255, 255, 50)); p1.setStyle(Style.FILL); 
		p2.setColor(Color.rgb(70, 70, 70)); p2.setStyle(Style.FILL);
		//p2.setColor(Color.WHITE);
		p3.setColor(Color.WHITE); p1.setStyle(Style.FILL);


		if (this.seleccionat) { 
			// Marc de item seleccionat
			RectF borde = new RectF(3, 3, this.getWidth() - 2, this.getHeight() - 2);
			canvas.drawRoundRect(borde, 5, 5, p1);
			this.setAlpha(2000);
			//this.setColorFilter(Color.YELLOW, PorterDuff.Mode.DST_IN);
		} else { 
			p1.setStyle(Style.FILL); 
			RectF borde = new RectF(5, 5, this.getWidth() - 5, this.getHeight() - 5);
			canvas.drawRoundRect(borde, 5, 5, p2);
			this.setAlpha(500);
		}
		
		//RectF interior = new RectF(9, 8, this.getWidth() - 8, this.getHeight() - 8);
		//canvas.drawRoundRect(interior, 5, 5, p1);

		super.onDraw(canvas);
	
		canvas.drawText(text_item, 15, 22, p3);

	}
	
}
