using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace GroceryStore
{
    public partial class meatControl: UserControl
    {
        public meatControl()
        {
            InitializeComponent();

            // Assign product details using Tag
            button1.Tag = new Product { Name = "CHILLED CHICKEN 1kg", Price = 180.00m };
            button2.Tag = new Product { Name = "LIEMPO 500g ", Price = 175.0m};
            button3.Tag = new Product { Name = "CHICKEN LEG QUARTER", Price = 131.45m };
            button4.Tag = new Product { Name = "PORK CHOP 500g ", Price = 172.50m };
            button5.Tag = new Product { Name = "TUNA 500g", Price = 150.50m };
            button6.Tag = new Product { Name = "SHRIMP 1kg", Price = 180.00m };
            button7.Tag = new Product { Name = "TILAPIA 500g", Price = 120.00m };
            button8.Tag = new Product { Name = "CHICKEN WINGS 1kg", Price = 120.50m };
            button9.Tag = new Product { Name = "BANGUS", Price = 165.75m };

            // Attach click events
            button1.Click += AddButton_Click;
            button2.Click += AddButton_Click;
            button3.Click += AddButton_Click;
            button4.Click += AddButton_Click;
            button5.Click += AddButton_Click;
            button6.Click += AddButton_Click;
            button7.Click += AddButton_Click;
            button8.Click += AddButton_Click; 
            button9.Click += AddButton_Click;
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

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void snackProductPanel_Paint(object sender, PaintEventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e) { }
        private void button2_Click(object sender, EventArgs e) { }
        private void button3_Click(object sender, EventArgs e) { }
        private void button4_Click(object sender, EventArgs e) { }

        private void button6_Click(object sender, EventArgs e) { }
    
        private void button7_Click(object sender, EventArgs e) { }
       
        private void button8_Click(object sender, EventArgs e) { }
       

        private void button9_Click(object sender, EventArgs e) { }
       

        private void button5_Click(object sender, EventArgs e) { }
        
    }
}
