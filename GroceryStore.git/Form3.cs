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
    public partial class AdminPage : Form
    {
        public AdminPage()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void salesBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = itemsBTN.Height;
            sidePanel.Top = itemsBTN.Top;
        }

        private void sidePanel_Paint(object sender, PaintEventArgs e)
        {

        }

        private void inventoryBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = salesBTN.Height;
            sidePanel.Top = salesBTN.Top;
        }

        private void reportBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = reportBTN.Height;
            sidePanel.Top = reportBTN.Top;
        }

        private void AdminPage_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            sidePanel.Height = inventoryBTN.Height;
            sidePanel.Top = inventoryBTN.Top;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
