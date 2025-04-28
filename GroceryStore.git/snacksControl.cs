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
    public partial class snacksControl : UserControl
    {
        
        public snacksControl()
        {
            InitializeComponent();

            // Assign product details using Tag
            button1.Tag = new Product { Name = "PIATTOS", Price = 17.95m };
            button2.Tag = new Product { Name = "MANG JUAN", Price = 10.95m };
            button3.Tag = new Product { Name = "MR.CHIPS", Price = 15.95m };
            button4.Tag = new Product { Name = "BURGER", Price = 25.00m };
            button5.Tag = new Product { Name = "BBQ FRIES", Price = 23.50m };
            button6.Tag = new Product { Name = "CHOCOLATE", Price = 15.00m };
            button7.Tag = new Product { Name = "PIZZA", Price = 35.75m };

            // Attach click events
            button1.Click += AddButton_Click;
            button2.Click += AddButton_Click;
            button3.Click += AddButton_Click;
            button4.Click += AddButton_Click;
            button5.Click += AddButton_Click;
            button6.Click += AddButton_Click;
            button7.Click += AddButton_Click;
        }

        // Shared event handler for all add buttons
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
            // Optional custom paint code
        }

        private void button1_Click(object sender, EventArgs e) { }
        private void button2_Click(object sender, EventArgs e) { }
        private void button3_Click(object sender, EventArgs e) { }
        private void button4_Click(object sender, EventArgs e) { }
        private void button5_Click(object sender, EventArgs e) { }
        private void button6_Click(object sender, EventArgs e) { }
        private void button7_Click(object sender, EventArgs e) { }
    }
}
