import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.planetas.Planeta
import com.example.planetas.R

class PlanetaAdapter(
    private val context: Context,
    private val planetas: List<Planeta>?,
    private val onClickListener: PlanetaOnClickListener
) :
    RecyclerView.Adapter<PlanetaAdapter.PlanetasViewHolder>() {
    // Interface que define o comportamento de clique
    interface PlanetaOnClickListener {
        fun onClickPlaneta(holder: PlanetasViewHolder?, idx: Int)
    }

    // Infla o layout e cria o ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int):
            PlanetasViewHolder {
// Este método cria uma subclasse de RecyclerView.ViewHolder
// Infla a view do layout
        val view = LayoutInflater.from(context).inflate(
            R.layout.adapter_planeta,
            viewGroup, false
        )
// Cria a classe do ViewHolder
        return PlanetasViewHolder(view)
    }

    // Retorna o tamanho da lista
    override fun getItemCount(): Int = planetas!!.size

    // Faz o bind das views no ViewHolder com os dados da lista
    override fun onBindViewHolder(
        holder: PlanetasViewHolder,
        position: Int
    ) {
// Este método recebe o índice do elemento, e atualiza as
// views que estão dentro do ViewHolder
        val planeta = planetas!![position]
// Atualizada os valores nas views
        holder.tNome.text = planeta.nome
        holder.img.setImageResource(planeta.imagem)
// Clique no item
        holder.itemView.setOnClickListener {
// Chama o listener para informar que clicou no Planeta
            onClickListener.onClickPlaneta(holder, position)
        }
    }

    // Subclasse de RecyclerView.ViewHolder.
// ViewHolder que guarda as referências das views do item
    class PlanetasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Cria as views para salvar no ViewHolder
        var tNome: TextView = view.findViewById(R.id.tNome)
        var img: ImageView = view.findViewById(R.id.img)
    }
}