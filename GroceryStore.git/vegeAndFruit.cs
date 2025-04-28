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
    public partial class vegeAndFruit: UserControl
    {
        public vegeAndFruit()
        {
            InitializeComponent();

            // Assign product details using Tag
            button1.Tag = new Product { Name = "APPLE 1kg", Price = 76.00m };
            button2.Tag = new Product { Name = "GRAPES 1kg ", Price = 85.75m };
            button3.Tag = new Product { Name = "MANGO 1kg", Price = 67.00m };
            button4.Tag = new Product { Name = "CABBAGE 1kg ", Price = 120.00m };
            button5.Tag = new Product { Name = "CARROT 1kg", Price = 140.50m };
            button6.Tag = new Product { Name = "GARLIC 1kg", Price = 125.50m };
            button7.Tag = new Product { Name = "TOMATO 1kg", Price = 89.00m };
            button8.Tag = new Product { Name = "ONION 1kg", Price = 250.00m };
          

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
        private void snackProductPanel_Paint(object sender, PaintEventArgs e)
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
