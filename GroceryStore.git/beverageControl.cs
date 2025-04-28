using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GroceryStore
{
    public partial class beverageControl: UserControl
    {
        public beverageControl()
        {
            InitializeComponent();

            // Assign product details using Tag
            button1.Tag = new Product { Name = "COCA-COLA", Price = 15.00m };
            button2.Tag = new Product { Name = "SPRITE", Price = 15.75m };
            button3.Tag = new Product { Name = "LEMON", Price = 15.95m };
            button4.Tag = new Product { Name = "PINEAPPLE", Price = 25.00m };
            button5.Tag = new Product { Name = "ORANGE", Price = 19.50m };
            button6.Tag = new Product { Name = "C2", Price = 15.00m };
            button7.Tag = new Product { Name = "BREWED COFFEE", Price = 39.00m };
            button8.Tag = new Product { Name = "YAKULT", Price = 13.00m };

            // Attach click events
            button1.Click += AddButton_Click;
            button2.Click += AddButton_Click;
            button3.Click += AddButton_Click;
            button4.Click += AddButton_Click;
            button5.Click += AddButton_Click;
            button6.Click += AddButton_Click;
            button7.Click += AddButton_Click;
            button8.Click += AddButton_Click;
        }
        private void AddButton_Click(object sender, EventArgs e)
        {
            Button btn = sender as Button;
            if (btn != null && btn.Tag is Product product)
            {

                // Get the parent form and cast it to Form2
                Form2 form = this.FindForm() as Form2;
                if (form != null)
                {
                    form.AddToCart(product);
                }
            }
        }


        private void snackProductPanel_Paint_1(object sender, PaintEventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e) { }
        private void button2_Click(object sender, EventArgs e) { }
        private void button3_Click(object sender, EventArgs e) { }
        private void button4_Click(object sender, EventArgs e) { }
        private void button5_Click(object sender, EventArgs e) { }
        private void button6_Click(object sender, EventArgs e) { }
        private void button7_Click(object sender, EventArgs e) { }
        private void button8_Click(object sender, EventArgs e) { }

    }
}
