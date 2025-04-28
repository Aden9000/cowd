namespace GroceryStore
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form2));
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle11 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle12 = new System.Windows.Forms.DataGridViewCellStyle();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.sidePanel = new System.Windows.Forms.Panel();
            this.meatsBTN = new System.Windows.Forms.Button();
            this.beverageBTN = new System.Windows.Forms.Button();
            this.snackBTN = new System.Windows.Forms.Button();
            this.vegeAndFruitBTN = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.cartPanel = new System.Windows.Forms.Panel();
            this.checkoutBTN = new System.Windows.Forms.Button();
            this.calcuPanel = new System.Windows.Forms.Panel();
            this.grandTotalLBL = new System.Windows.Forms.Label();
            this.amountDiscountLBL = new System.Windows.Forms.Label();
            this.percentDiscountLBL = new System.Windows.Forms.Label();
            this.totalCostLBL = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.cartdataGridView = new System.Windows.Forms.DataGridView();
            this.qty = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.productName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.totalAmount = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.deleteButton = new System.Windows.Forms.DataGridViewButtonColumn();
            this.label2 = new System.Windows.Forms.Label();
            this.meatControl1 = new GroceryStore.meatControl();
            this.vegeAndFruit1 = new GroceryStore.vegeAndFruit();
            this.beverageControl1 = new GroceryStore.beverageControl();
            this.snacksControl1 = new GroceryStore.snacksControl();
            this.riceControl1 = new GroceryStore.meatControl();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.cartPanel.SuspendLayout();
            this.calcuPanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cartdataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.DarkOliveGreen;
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.pictureBox1);
            this.panel1.Controls.Add(this.sidePanel);
            this.panel1.Controls.Add(this.meatsBTN);
            this.panel1.Controls.Add(this.beverageBTN);
            this.panel1.Controls.Add(this.snackBTN);
            this.panel1.Controls.Add(this.vegeAndFruitBTN);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(131, 460);
            this.panel1.TabIndex = 0;
            this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.BlanchedAlmond;
            this.label1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.label1.Font = new System.Drawing.Font("Britannic Bold", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Black;
            this.label1.Location = new System.Drawing.Point(8, 83);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(117, 12);
            this.label1.TabIndex = 7;
            this.label1.Text = "TINDAHAN DE ALKANSE";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(31, 8);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(75, 66);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 6;
            this.pictureBox1.TabStop = false;
            // 
            // sidePanel
            // 
            this.sidePanel.Location = new System.Drawing.Point(0, 171);
            this.sidePanel.Margin = new System.Windows.Forms.Padding(2);
            this.sidePanel.Name = "sidePanel";
            this.sidePanel.Size = new System.Drawing.Size(9, 42);
            this.sidePanel.TabIndex = 5;
            this.sidePanel.Paint += new System.Windows.Forms.PaintEventHandler(this.sidePanel_Paint);
            // 
            // meatsBTN
            // 
            this.meatsBTN.Cursor = System.Windows.Forms.Cursors.Hand;
            this.meatsBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.meatsBTN.Image = ((System.Drawing.Image)(resources.GetObject("meatsBTN.Image")));
            this.meatsBTN.Location = new System.Drawing.Point(0, 259);
            this.meatsBTN.Margin = new System.Windows.Forms.Padding(2);
            this.meatsBTN.Name = "meatsBTN";
            this.meatsBTN.Size = new System.Drawing.Size(131, 40);
            this.meatsBTN.TabIndex = 3;
            this.meatsBTN.Text = "MEATS";
            this.meatsBTN.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.meatsBTN.UseVisualStyleBackColor = true;
            this.meatsBTN.Click += new System.EventHandler(this.meatsBTN_Click);
            // 
            // beverageBTN
            // 
            this.beverageBTN.Cursor = System.Windows.Forms.Cursors.Hand;
            this.beverageBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.beverageBTN.Image = ((System.Drawing.Image)(resources.GetObject("beverageBTN.Image")));
            this.beverageBTN.Location = new System.Drawing.Point(0, 215);
            this.beverageBTN.Margin = new System.Windows.Forms.Padding(2);
            this.beverageBTN.Name = "beverageBTN";
            this.beverageBTN.Size = new System.Drawing.Size(131, 40);
            this.beverageBTN.TabIndex = 2;
            this.beverageBTN.Text = "DRINKS";
            this.beverageBTN.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.beverageBTN.UseVisualStyleBackColor = true;
            this.beverageBTN.Click += new System.EventHandler(this.beverageBTN_Click);
            // 
            // snackBTN
            // 
            this.snackBTN.Cursor = System.Windows.Forms.Cursors.Hand;
            this.snackBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.snackBTN.Image = ((System.Drawing.Image)(resources.GetObject("snackBTN.Image")));
            this.snackBTN.Location = new System.Drawing.Point(0, 171);
            this.snackBTN.Margin = new System.Windows.Forms.Padding(2);
            this.snackBTN.Name = "snackBTN";
            this.snackBTN.Size = new System.Drawing.Size(131, 40);
            this.snackBTN.TabIndex = 1;
            this.snackBTN.Text = "SNACKS";
            this.snackBTN.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.snackBTN.UseVisualStyleBackColor = true;
            this.snackBTN.Click += new System.EventHandler(this.snackBTN_Click);
            // 
            // vegeAndFruitBTN
            // 
            this.vegeAndFruitBTN.Cursor = System.Windows.Forms.Cursors.Hand;
            this.vegeAndFruitBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.vegeAndFruitBTN.Image = ((System.Drawing.Image)(resources.GetObject("vegeAndFruitBTN.Image")));
            this.vegeAndFruitBTN.Location = new System.Drawing.Point(0, 304);
            this.vegeAndFruitBTN.Margin = new System.Windows.Forms.Padding(2);
            this.vegeAndFruitBTN.Name = "vegeAndFruitBTN";
            this.vegeAndFruitBTN.Size = new System.Drawing.Size(131, 40);
            this.vegeAndFruitBTN.TabIndex = 0;
            this.vegeAndFruitBTN.Text = "VEGETABLE AND FRUITS";
            this.vegeAndFruitBTN.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.vegeAndFruitBTN.UseVisualStyleBackColor = true;
            this.vegeAndFruitBTN.Click += new System.EventHandler(this.vegeAndFruitBTN_Click);
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.DarkSeaGreen;
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.Location = new System.Drawing.Point(131, 0);
            this.panel2.Margin = new System.Windows.Forms.Padding(2);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(782, 21);
            this.panel2.TabIndex = 2;
            // 
            // cartPanel
            // 
            this.cartPanel.BackColor = System.Drawing.SystemColors.ControlLight;
            this.cartPanel.Controls.Add(this.checkoutBTN);
            this.cartPanel.Controls.Add(this.calcuPanel);
            this.cartPanel.Controls.Add(this.cartdataGridView);
            this.cartPanel.Controls.Add(this.label2);
            this.cartPanel.Dock = System.Windows.Forms.DockStyle.Right;
            this.cartPanel.Location = new System.Drawing.Point(422, 21);
            this.cartPanel.Margin = new System.Windows.Forms.Padding(2);
            this.cartPanel.Name = "cartPanel";
            this.cartPanel.Size = new System.Drawing.Size(491, 439);
            this.cartPanel.TabIndex = 3;
            // 
            // checkoutBTN
            // 
            this.checkoutBTN.BackColor = System.Drawing.Color.PaleGoldenrod;
            this.checkoutBTN.Cursor = System.Windows.Forms.Cursors.Hand;
            this.checkoutBTN.Location = new System.Drawing.Point(7, 327);
            this.checkoutBTN.Margin = new System.Windows.Forms.Padding(2);
            this.checkoutBTN.Name = "checkoutBTN";
            this.checkoutBTN.Size = new System.Drawing.Size(73, 27);
            this.checkoutBTN.TabIndex = 7;
            this.checkoutBTN.Text = "CHECK OUT";
            this.checkoutBTN.UseVisualStyleBackColor = false;
            this.checkoutBTN.Click += new System.EventHandler(this.checkoutBTN_Click);
            // 
            // calcuPanel
            // 
            this.calcuPanel.Controls.Add(this.grandTotalLBL);
            this.calcuPanel.Controls.Add(this.amountDiscountLBL);
            this.calcuPanel.Controls.Add(this.percentDiscountLBL);
            this.calcuPanel.Controls.Add(this.totalCostLBL);
            this.calcuPanel.Controls.Add(this.label6);
            this.calcuPanel.Controls.Add(this.label5);
            this.calcuPanel.Controls.Add(this.label4);
            this.calcuPanel.Controls.Add(this.label3);
            this.calcuPanel.Location = new System.Drawing.Point(191, 327);
            this.calcuPanel.Margin = new System.Windows.Forms.Padding(2);
            this.calcuPanel.Name = "calcuPanel";
            this.calcuPanel.Size = new System.Drawing.Size(298, 123);
            this.calcuPanel.TabIndex = 6;
            // 
            // grandTotalLBL
            // 
            this.grandTotalLBL.AutoSize = true;
            this.grandTotalLBL.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.grandTotalLBL.Location = new System.Drawing.Point(167, 90);
            this.grandTotalLBL.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.grandTotalLBL.Name = "grandTotalLBL";
            this.grandTotalLBL.Size = new System.Drawing.Size(49, 17);
            this.grandTotalLBL.TabIndex = 9;
            this.grandTotalLBL.Text = "##.##";
            // 
            // amountDiscountLBL
            // 
            this.amountDiscountLBL.AutoSize = true;
            this.amountDiscountLBL.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.amountDiscountLBL.Location = new System.Drawing.Point(167, 55);
            this.amountDiscountLBL.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.amountDiscountLBL.Name = "amountDiscountLBL";
            this.amountDiscountLBL.Size = new System.Drawing.Size(49, 17);
            this.amountDiscountLBL.TabIndex = 8;
            this.amountDiscountLBL.Text = "##.##";
            // 
            // percentDiscountLBL
            // 
            this.percentDiscountLBL.AutoSize = true;
            this.percentDiscountLBL.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.percentDiscountLBL.Location = new System.Drawing.Point(167, 31);
            this.percentDiscountLBL.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.percentDiscountLBL.Name = "percentDiscountLBL";
            this.percentDiscountLBL.Size = new System.Drawing.Size(49, 17);
            this.percentDiscountLBL.TabIndex = 7;
            this.percentDiscountLBL.Text = "##.##";
            // 
            // totalCostLBL
            // 
            this.totalCostLBL.AutoSize = true;
            this.totalCostLBL.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.totalCostLBL.Location = new System.Drawing.Point(167, 10);
            this.totalCostLBL.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.totalCostLBL.Name = "totalCostLBL";
            this.totalCostLBL.Size = new System.Drawing.Size(49, 17);
            this.totalCostLBL.TabIndex = 6;
            this.totalCostLBL.Text = "##.##";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(43, 90);
            this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(129, 17);
            this.label6.TabIndex = 5;
            this.label6.Text = "GRAND TOTAL: ";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(9, 55);
            this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(163, 17);
            this.label5.TabIndex = 4;
            this.label5.Text = "DISCOUNT AMOUNT:\r\n";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(2, 31);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(169, 17);
            this.label4.TabIndex = 3;
            this.label4.Text = "PERCENT DISCOUNT:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(55, 10);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(111, 17);
            this.label3.TabIndex = 2;
            this.label3.Text = "TOTAL COST:";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // cartdataGridView
            // 
            this.cartdataGridView.AllowUserToAddRows = false;
            this.cartdataGridView.AllowUserToDeleteRows = false;
            this.cartdataGridView.AllowUserToResizeColumns = false;
            this.cartdataGridView.AllowUserToResizeRows = false;
            this.cartdataGridView.BackgroundColor = System.Drawing.Color.FloralWhite;
            this.cartdataGridView.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.cartdataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.cartdataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.qty,
            this.productName,
            this.price,
            this.totalAmount,
            this.deleteButton});
            this.cartdataGridView.Location = new System.Drawing.Point(-2, 22);
            this.cartdataGridView.Margin = new System.Windows.Forms.Padding(2);
            this.cartdataGridView.Name = "cartdataGridView";
            this.cartdataGridView.ReadOnly = true;
            this.cartdataGridView.RowHeadersVisible = false;
            this.cartdataGridView.RowHeadersWidth = 62;
            this.cartdataGridView.RowTemplate.Height = 28;
            this.cartdataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.cartdataGridView.Size = new System.Drawing.Size(491, 301);
            this.cartdataGridView.TabIndex = 1;
            this.cartdataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.cartdataGridView_CellContentClick_1);
            // 
            // qty
            // 
            this.qty.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            dataGridViewCellStyle11.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            this.qty.DefaultCellStyle = dataGridViewCellStyle11;
            this.qty.HeaderText = "Qty";
            this.qty.MinimumWidth = 8;
            this.qty.Name = "qty";
            this.qty.ReadOnly = true;
            this.qty.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.qty.Width = 90;
            // 
            // productName
            // 
            this.productName.HeaderText = "Product";
            this.productName.MinimumWidth = 8;
            this.productName.Name = "productName";
            this.productName.ReadOnly = true;
            this.productName.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.productName.Width = 320;
            // 
            // price
            // 
            this.price.HeaderText = "Price";
            this.price.MinimumWidth = 8;
            this.price.Name = "price";
            this.price.ReadOnly = true;
            this.price.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.price.Width = 130;
            // 
            // totalAmount
            // 
            this.totalAmount.HeaderText = "Total Amount";
            this.totalAmount.MinimumWidth = 8;
            this.totalAmount.Name = "totalAmount";
            this.totalAmount.ReadOnly = true;
            this.totalAmount.Width = 130;
            // 
            // deleteButton
            // 
            dataGridViewCellStyle12.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle12.BackColor = System.Drawing.Color.YellowGreen;
            dataGridViewCellStyle12.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle12.ForeColor = System.Drawing.Color.Black;
            dataGridViewCellStyle12.SelectionBackColor = System.Drawing.Color.Beige;
            dataGridViewCellStyle12.SelectionForeColor = System.Drawing.Color.Black;
            this.deleteButton.DefaultCellStyle = dataGridViewCellStyle12;
            this.deleteButton.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.deleteButton.HeaderText = "";
            this.deleteButton.MinimumWidth = 8;
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.ReadOnly = true;
            this.deleteButton.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.deleteButton.Text = "delete";
            this.deleteButton.UseColumnTextForButtonValue = true;
            this.deleteButton.Width = 65;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(2, 4);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(96, 17);
            this.label2.TabIndex = 0;
            this.label2.Text = "Current Order";
            // 
            // meatControl1
            // 
            this.meatControl1.AutoSize = true;
            this.meatControl1.Location = new System.Drawing.Point(131, 21);
            this.meatControl1.Margin = new System.Windows.Forms.Padding(1);
            this.meatControl1.Name = "meatControl1";
            this.meatControl1.Size = new System.Drawing.Size(517, 449);
            this.meatControl1.TabIndex = 0;
            this.meatControl1.Load += new System.EventHandler(this.meatControl1_Load);
            // 
            // vegeAndFruit1
            // 
            this.vegeAndFruit1.Location = new System.Drawing.Point(131, 21);
            this.vegeAndFruit1.Margin = new System.Windows.Forms.Padding(1);
            this.vegeAndFruit1.Name = "vegeAndFruit1";
            this.vegeAndFruit1.Size = new System.Drawing.Size(517, 449);
            this.vegeAndFruit1.TabIndex = 7;
            // 
            // beverageControl1
            // 
            this.beverageControl1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.beverageControl1.Location = new System.Drawing.Point(131, 21);
            this.beverageControl1.Margin = new System.Windows.Forms.Padding(1);
            this.beverageControl1.Name = "beverageControl1";
            this.beverageControl1.Size = new System.Drawing.Size(782, 439);
            this.beverageControl1.TabIndex = 6;
            // 
            // snacksControl1
            // 
            this.snacksControl1.Location = new System.Drawing.Point(131, 21);
            this.snacksControl1.Margin = new System.Windows.Forms.Padding(1);
            this.snacksControl1.Name = "snacksControl1";
            this.snacksControl1.Size = new System.Drawing.Size(515, 447);
            this.snacksControl1.TabIndex = 5;
            // 
            // riceControl1
            // 
            this.riceControl1.Location = new System.Drawing.Point(135, 21);
            this.riceControl1.Margin = new System.Windows.Forms.Padding(1);
            this.riceControl1.Name = "riceControl1";
            this.riceControl1.Size = new System.Drawing.Size(515, 447);
            this.riceControl1.TabIndex = 4;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackColor = System.Drawing.Color.Cornsilk;
            this.ClientSize = new System.Drawing.Size(913, 460);
            this.Controls.Add(this.cartPanel);
            this.Controls.Add(this.meatControl1);
            this.Controls.Add(this.vegeAndFruit1);
            this.Controls.Add(this.beverageControl1);
            this.Controls.Add(this.snacksControl1);
            this.Controls.Add(this.riceControl1);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form2";
            this.Load += new System.EventHandler(this.Form2_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.cartPanel.ResumeLayout(false);
            this.cartPanel.PerformLayout();
            this.calcuPanel.ResumeLayout(false);
            this.calcuPanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.cartdataGridView)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button snackBTN;
        private System.Windows.Forms.Button meatsBTN;
        private System.Windows.Forms.Button beverageBTN;
        private System.Windows.Forms.Panel sidePanel;
        public System.Windows.Forms.Button vegeAndFruitBTN;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel cartPanel;
        private meatControl riceControl1;
        private snacksControl snacksControl1;
        private beverageControl beverageControl1;
        private vegeAndFruit vegeAndFruit1;
        private meatControl meatControl1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView cartdataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn qty;
        private System.Windows.Forms.DataGridViewTextBoxColumn productName;
        private System.Windows.Forms.DataGridViewTextBoxColumn price;
        private System.Windows.Forms.DataGridViewTextBoxColumn totalAmount;
        private System.Windows.Forms.DataGridViewButtonColumn deleteButton;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Panel calcuPanel;
        private System.Windows.Forms.Button checkoutBTN;
        private System.Windows.Forms.Label amountDiscountLBL;
        private System.Windows.Forms.Label percentDiscountLBL;
        private System.Windows.Forms.Label totalCostLBL;
        private System.Windows.Forms.Label grandTotalLBL;
    }
}