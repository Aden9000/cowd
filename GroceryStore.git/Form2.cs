using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace GroceryStore
{
    public partial class Form2 : Form
    {
        // Dictionary to store product and quantity in the cart
        private Dictionary<Product, int> cartItems = new Dictionary<Product, int>();

        public Form2()
        {
            InitializeComponent();
            cartdataGridView.CellContentClick += cartdataGridView_CellContentClick;
            cartdataGridView.CellBorderStyle = DataGridViewCellBorderStyle.None;
        }

        private void vegeAndFruitBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = vegeAndFruitBTN.Height;
            sidePanel.Top = vegeAndFruitBTN.Top;
            vegeAndFruit1.BringToFront();
        }

        private void snackBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = snackBTN.Height;
            sidePanel.Top = snackBTN.Top;
            snacksControl1.BringToFront();
        }

        private void beverageBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = beverageBTN.Height;
            sidePanel.Top = beverageBTN.Top;
            beverageControl1.BringToFront();
        }

        private void meatsBTN_Click(object sender, EventArgs e)
        {
            sidePanel.Height = meatsBTN.Height;
            sidePanel.Top = meatsBTN.Top;
            meatControl1.BringToFront();
        }

        // Public method to add or update a product in the cart
        public void AddToCart(Product product)
        {
            if (cartItems.ContainsKey(product))
            {
                cartItems[product]++;
            }
            else
            {
                cartItems.Add(product, 1);
            }

            DisplayCart();
            UpdateSummaryLabels(); // Automatically update totals
        }

        // Method to display cart items in the DataGridView
        private void DisplayCart()
        {
            cartdataGridView.Rows.Clear();

            foreach (var item in cartItems)
            {
                Product product = item.Key;
                int quantity = item.Value;
                decimal totalAmount = quantity * product.Price;

                int rowIndex = cartdataGridView.Rows.Add();
                DataGridViewRow row = cartdataGridView.Rows[rowIndex];

                row.Cells["qty"].Value = quantity;
                row.Cells["productName"].Value = product.Name;
                row.Cells["price"].Value = $"₱{product.Price}";
                row.Cells["totalAmount"].Value = $"₱{totalAmount}";
                row.Tag = product; // Save product object for easy reference
            }

            cartdataGridView.ClearSelection();
        }

        // Handles delete button click in the DataGridView
        private void cartdataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == cartdataGridView.Columns["deleteButton"].Index && e.RowIndex >= 0)
            {
                DataGridViewRow selectedRow = cartdataGridView.Rows[e.RowIndex];
                Product product = (Product)selectedRow.Tag;

                if (cartItems.ContainsKey(product))
                {
                    if (cartItems[product] > 1)
                        cartItems[product]--;
                    else
                        cartItems.Remove(product);

                    DisplayCart();
                    UpdateSummaryLabels(); // Automatically update totals
                }
            }
        }

        // Calculates the total amount of all items in the cart
        public double calcuTotalAmount()
        {
            double total = 0;

            foreach (var item in cartItems)
            {
                Product product = item.Key;
                int quantity = item.Value;
                total += (double)(product.Price * quantity);
            }

            return total;
        }

        // Calculates the discount amount using the discount percent
        public double calcuDiscountAmount(double totalAmount)
        {
            int discountPercent = calcuPercentDiscount((int)totalAmount);
            double discountAmount = (totalAmount * discountPercent) / 100;
            return discountAmount;
        }

        // Calculates the final total after applying discount
        public double calcuFinalPrice()
        {
            double totalAmount = calcuTotalAmount();
            double discountAmount = calcuDiscountAmount(totalAmount);
            double finalPrice = totalAmount - discountAmount;
            return finalPrice;
        }

        public int calcuPercentDiscount(int totalAmount)
        {
            if (totalAmount <= 0)
            {
                return 0;
            }
            else if (totalAmount >= 100 && totalAmount < 200)
            {
                return 10;
            }
            else if (totalAmount >= 200 && totalAmount < 500)
            {
                return 15;
            }
            else
            {
                return 20;
            }
        }

        // Updates labels with current totals and discounts
        private void UpdateSummaryLabels()
        {
            double totalAmount = calcuTotalAmount();
            double discount = calcuDiscountAmount(totalAmount);
            double finalAmount = calcuFinalPrice();
            int percentDiscount = calcuPercentDiscount((int)totalAmount);

            totalCostLBL.Text = $"₱{totalAmount:F2}";
            percentDiscountLBL.Text = $"{percentDiscount}%";
            amountDiscountLBL.Text = $"₱{discount:F2}";
            grandTotalLBL.Text = $"₱{finalAmount:F2}";
        }

        private void checkoutBTN_Click(object sender, EventArgs e)
        {
            UpdateSummaryLabels(); // Ensure labels are updated

            string receipt = "==================== RECEIPT =====================\n";

            foreach (var item in cartItems)
            {
                Product product = item.Key;
                int qty = item.Value;
                decimal lineTotal = qty * product.Price;
                receipt += $"{qty} x {product.Name} @ ₱{product.Price} = ₱{lineTotal:F2}\n";
            }

            receipt += "\n--------------------------------------------------\n";
            receipt += $"Total: {totalCostLBL.Text}\n";
            receipt += $"Discount ({percentDiscountLBL.Text}): -{amountDiscountLBL.Text}\n";
            receipt += $"Grand Total: {grandTotalLBL.Text}\n";
            receipt += "==================================================";

            ReceiptForm rcp = new ReceiptForm(receipt);
            this.Hide();
            rcp.ShowDialog();
            this.Show();
            // Optional: Clear cart after checkout
            cartItems.Clear();
            DisplayCart();
            UpdateSummaryLabels();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            // Initialization if needed
        }

        private void meatControl1_Load(object sender, EventArgs e)
        {
            // Optional setup
        }

        private void cartdataGridView_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
            // Unused duplicate handler
        }

        private void label3_Click(object sender, EventArgs e)
        {
            // Unused
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            // Unused
        }

        private void sidePanel_Paint(object sender, PaintEventArgs e)
        {

        }
    }

    public class Product
    {
        public string Name { get; set; }
        public decimal Price { get; set; }
    }
}

