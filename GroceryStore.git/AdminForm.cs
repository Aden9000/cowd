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
    public partial class AdminForm: Form
    {
        public AdminForm()
        {
            InitializeComponent();
        }
        //Admin Log in info.
        private string adminpass = "shancai123";
        private string adminuser = "Nicky Estrada";
        private void storeBox_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1();
            this.Hide(); // Hide Form1
            f1.FormClosed += (s, args) => this.Show(); // Show Form1 again when Form2 is closed
            f1.Show(); // Use Show (not ShowDialog) so FormClosed can trigger
        }

        private void AdminForm_Load(object sender, EventArgs e)
        {
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (passwordTextBox.Text.Equals(adminpass, StringComparison.Ordinal) && userTextBox.Text.Equals(adminuser, StringComparison.Ordinal))
            {
                AdminPage AP = new AdminPage();
                this.Hide();
                AP.FormClosed += (s, args) => this.Show();
                AP.Show();

                passwordTextBox.Clear();
                userTextBox.Clear();
            }
            else
            {
                MessageBox.Show("Incorrect username or password!", "Login Failed", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void userTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void passwordTextBox_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
