package com.example.freshdesk.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.freshdesk.api.models.ReportClientAndModuleItem
import com.example.freshdesk.api.models.ReportModularlyItem
import com.example.freshdesk.databinding.ItemByClientsBinding
import com.example.freshdesk.databinding.ItemModularyBottomBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class ClientsAdapter(private val list: List<ReportClientAndModuleItem>): RecyclerView.Adapter<ClientsAdapter.ViewHolder>() {
    class ViewHolder(val databinding: ItemByClientsBinding): RecyclerView.ViewHolder(databinding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemByClientsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item = list[position]
        holder.databinding.let {
            it.name.text = item.name
            it.credits.text=item.credits.toString()
            it.rko.text=item.rko.toString()
            it.aur.text=item.aur.toString()
            it.accounting.text=item.accountingDepartment.toString()
            it.deposits.text=item.depositsSettlement.toString()
            it.ib.text=item.ib.toString()
            it.cards.text=item.carts.toString()
            it.cash.text=item.cashbox.toString()
            it.clients.text=item.clients.toString()
            it.compliance.text=item.complaens.toString()
            it.reference.text=item.referenceData.toString()
            it.service.text=item.service.toString()
            it.reports.text=item.reports.toString()
            it.pledge.text=item.pledges.toString()
            it.prbo.text=item.prbo.toString()
            it.baseReference.text=item.basicGuides.toString()
            it.eWallet.text=item.eWallet.toString()
            it.esp.text=item.acp.toString()
            it.treasuryOperations.text=item.treasuryOperations.toString()
            it.integration.text=item.integrationService.toString()
            if (position % 2 == 0) {
                holder.databinding.let {
                    it.namecard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.rkoCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.accountingCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.ibCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.cashCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.complianceCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.serviceCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.pledgeCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.baseReferenceCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.espCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                    it.integrationCard.setCardBackgroundColor(Color.parseColor("#DBDBDB"))
                }
            }
        }
    }
        override fun getItemCount(): Int {
            return list.size
        }
    }