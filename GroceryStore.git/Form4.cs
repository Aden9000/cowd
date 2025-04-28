using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GroceryStore
{
    public partial class ReceiptForm : Form
    {
        public ReceiptForm(string receipt)
        {
            InitializeComponent();
            rcptLBL.Text = receipt; 
        }

        private void receiptPNL_Paint(object sender, PaintEventArgs e)
        {

        }

        private void rcptLBL_Click(object sender, EventArgs e)
        {

        }

        private void ReceiptForm_Load(object sender, EventArgs e)
        {

        }
    }
}
