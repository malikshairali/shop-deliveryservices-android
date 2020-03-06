package com.godeliveryservices.shop.ui.cash_reports

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.godeliveryservices.shop.R
import com.godeliveryservices.shop.dummy.DummyContent.DummyItem
import com.godeliveryservices.shop.models.Order
import kotlinx.android.synthetic.main.list_item_cash_history.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class CashReportsRecyclerViewAdapter(
    private var mValues: List<Order>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<CashReportsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Order
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    fun setValues(orders: List<Order>) {
        mValues = orders
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_cash_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mView.order_date_text.text = item.orderDateFormatted ?: ""
        holder.mView.order_number_text.text =
            holder.mView.resources.getString(R.string.format_order_number, item.OrderID)
        holder.mView.rider_name_text.text = item.RiderName
//        holder.mView.branch_name_text.text = item.ShopBranch?.Name
        holder.mView.price_text.text =
            holder.mView.price_text.resources.getString(R.string.format_order_price, item.Amount)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val mIdView: TextView = mView.item_number
//        val mContentView: TextView = mView.content

//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
    }
}


/**
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
 *
 *
 * See the Android Training lesson
 * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
 * for more information.
 */
interface OnListFragmentInteractionListener {
    // TODO: Update argument type and name
    fun onListFragmentInteraction(item: Order?)
}
