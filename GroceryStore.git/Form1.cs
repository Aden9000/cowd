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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            this.Hide(); // Hide Form1
            f2.FormClosed += (s, args) => this.Show(); // Show Form1 again when Form2 is closed
            f2.Show(); // Use Show (not ShowDialog) so FormClosed can trigger
        }

        private void adminBox_Click(object sender, EventArgs e)
        {
            AdminForm AF = new AdminForm();
            this.Hide();
            AF.FormClosed += (s, args) => this.Show(); // Same logic for AdminForm
            AF.Show();
        }
    }
}